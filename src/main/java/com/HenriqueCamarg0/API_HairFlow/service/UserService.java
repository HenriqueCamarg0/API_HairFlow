package com.HenriqueCamarg0.API_HairFlow.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.HenriqueCamarg0.API_HairFlow.Entity.User;
import com.HenriqueCamarg0.API_HairFlow.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import com.HenriqueCamarg0.API_HairFlow.dto.UserDTO;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public User register(UserDTO dto) {
       
        User user = new User(null, null, null, null);
        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());
        user.setPassword(passwordEncoder.encode(dto.getPassword())); // Criptografando senha
        user.setRole(dto.getRole()); // Definindo o papel do usuário (ROLE_CUSTOMER ou ROLE_ADMIN)     
           
        return userRepository.save(user);
    }

    public User authenticate(UserDTO dto) {
        User user = userRepository.findByEmail(dto.getEmail())
            .orElseThrow(() -> new RuntimeException("Usuário não encontrado!"));

        if (!passwordEncoder.matches(dto.getPassword(), user.getPassword())) {
            throw new RuntimeException("Senha incorreta!");
        }

        return user;
    }

}