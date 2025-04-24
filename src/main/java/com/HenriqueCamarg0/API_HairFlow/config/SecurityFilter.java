package com.HenriqueCamarg0.API_HairFlow.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.HenriqueCamarg0.API_HairFlow.repository.UserRepository;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class SecurityFilter extends OncePerRequestFilter { 

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UserRepository userRepository;

    @SuppressWarnings("null")
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        var token = this.recoverToken(request);

        if (token != null) {
            // Valida o token e recupera o username
            var username = tokenService.validateToken(token);

            if (username != null) {
                // Busca os detalhes do usuário no banco de dados
                UserDetails userDetails = userRepository.findByUsername(username).orElse(null);

                if (userDetails != null) {
                    // Cria a autenticação com UserDetails e Authorities
                    var authentication = new UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.getAuthorities()
                    );

                    // Configura o contexto de segurança
                    SecurityContextHolder.getContext().setAuthentication(authentication);

                    // Adiciona o usuário autenticado na requisição
                    request.setAttribute("user", userDetails);
                }
            }
        }

        // Continua para o próximo filtro na cadeia
        filterChain.doFilter(request, response);
    }

    private String recoverToken(HttpServletRequest request) {
        var authorizationHeader = request.getHeader("Authorization");

        if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
            return null;
        }

        // Remove "Bearer " do cabeçalho e retorna o token
        return authorizationHeader.replace("Bearer ", "");
    }
}