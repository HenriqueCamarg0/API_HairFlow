package com.HenriqueCamarg0.API_HairFlow.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.core.Authentication; // Added missing import
import org.springframework.stereotype.Service;

import com.HenriqueCamarg0.API_HairFlow.Entity.User;
import com.HenriqueCamarg0.API_HairFlow.Entity.UserRole;
import com.HenriqueCamarg0.API_HairFlow.dto.LoginDTO;
import com.HenriqueCamarg0.API_HairFlow.dto.RegisterDTO;
import com.HenriqueCamarg0.API_HairFlow.repository.UserRepository;
import com.HenriqueCamarg0.API_HairFlow.security.JwtTokenProvider;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class AuthService {
    
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider tokenProvider;

    public void registerUser(RegisterDTO registerDTO) {
        if (userRepository.existsByUsername(registerDTO.getUsername())) {
            throw new RuntimeException("Username já existe");
        }

        if (userRepository.existsByEmail(registerDTO.getEmail())) {
            throw new RuntimeException("Email já está em uso");
        }

        User user = new User();
        user.setUsername(registerDTO.getUsername());
        user.setPassword(passwordEncoder.encode(registerDTO.getPassword()));
        user.setEmail(registerDTO.getEmail());
        user.setPhoneNumber(registerDTO.getPhoneNumber());
        user.setRole(UserRole.CUSTOMER); // Papel padrão

        userRepository.save(user);
    }
// Removed duplicate and invalid method
private final AuthenticationManager authenticationManager;

public String authenticateUser(LoginDTO loginDTO) {
    Authentication authentication = authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(
            loginDTO.getUsername(),
            loginDTO.getPassword()
        )
    );

    SecurityContextHolder.getContext().setAuthentication(authentication);
    return tokenProvider.generateToken(authentication);
}
}
