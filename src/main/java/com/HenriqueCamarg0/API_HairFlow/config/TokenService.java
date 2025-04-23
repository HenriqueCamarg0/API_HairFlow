
package com.HenriqueCamarg0.API_HairFlow.config;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import com.HenriqueCamarg0.API_HairFlow.Entity.User;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;

@Service
public class TokenService {

    // Injeta o valor do segredo do token JWT a partir do arquivo de propriedades
    // Isso permite que o segredo seja configurado externamente, por exemplo, em um arquivo application.properties
    @Value("${api.security.token.secret}") 
    private String secret;

    // Método para gerar o token JWT
    public String generateToken(UserDetails user) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.create()
                .withIssuer("API HairFlow")
                .withSubject(user.getUsername())
                .withExpiresAt(Date.from(genExpirationData()))
                .sign(algorithm);
        } catch (JWTCreationException exception) {
            throw new RuntimeException("Erro ao criar token JWT", exception);
        }
    }

    // Método para validar o token JWT
    public String validateToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm)
                .withIssuer("API HairFlow")
                .build()
                .verify(token)
                .getSubject();
        } catch (JWTVerificationException exception) {
            return ""; // Retorna null se o token não for válido
        }
    }

    // Método para gerar a data de expiração do token
    private Instant genExpirationData() {
        return LocalDateTime.now()
            .plusHours(2)
            .toInstant(ZoneOffset.of("-03:00")); // Configura a expiração para 2 horas
    }


}