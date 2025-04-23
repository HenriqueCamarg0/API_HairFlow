package com.HenriqueCamarg0.API_HairFlow.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.HenriqueCamarg0.API_HairFlow.repository.UserRepository;

@Service
public class AuthorizationService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        // Aqui você pode implementar a lógica para carregar o usuário do banco de dados
        // e retornar um objeto UserDetails correspondente.
        return userRepository.findByEmail(username)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado!"));
    }
}
