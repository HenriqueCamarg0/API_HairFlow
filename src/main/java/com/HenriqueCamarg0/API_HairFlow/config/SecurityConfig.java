package com.HenriqueCamarg0.API_HairFlow.config;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Value("${allowed.origin}")
    private String allowedOrigin;

    @Autowired
    SecurityFilter securityFilter; 
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
        .cors(cors -> cors.configurationSource(request -> {
            var corsConfiguration = new CorsConfiguration();
            corsConfiguration.setAllowedOrigins(List.of(allowedOrigin));
            corsConfiguration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
            corsConfiguration.setAllowedHeaders(List.of("*"));
            corsConfiguration.setAllowCredentials(true);
            return corsConfiguration;
        }))
            .csrf(csrf -> csrf.disable()) // Desabilita CSRF
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)) // Define sessão como stateless
            .authorizeHttpRequests(auth -> auth
                // .requestMatchers(HttpMethod.POST, "/api/auth/login").permitAll() // Permite acesso ao endpoint de login
                // .requestMatchers(HttpMethod.POST, "/api/auth/register").permitAll() // Permite acesso ao endpoint de registro                .requestMatchers("/api/user/register").hasRole("ADMIN") // Apenas ADMIN pode registrar usuários
                // .anyRequest().authenticated() // Qualquer outra requisição deve ser autenticada
                .anyRequest().permitAll() // Permite todas as rotas
            )
        .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class); // Adiciona o filtro JWT antes do filtro de autenticação padrão
        
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // Usando BCrypt para criptografar senhas
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration auth) throws Exception {
    return auth.getAuthenticationManager(); // Retorna o AuthenticationManager configurado
    }

}