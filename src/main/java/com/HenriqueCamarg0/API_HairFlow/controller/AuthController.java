package com.HenriqueCamarg0.API_HairFlow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;

import com.HenriqueCamarg0.API_HairFlow.Entity.User;
import com.HenriqueCamarg0.API_HairFlow.config.TokenService;
import com.HenriqueCamarg0.API_HairFlow.dto.LoginResponseDTO;
import com.HenriqueCamarg0.API_HairFlow.dto.RegisterDTO;
import com.HenriqueCamarg0.API_HairFlow.dto.UserDTO;
import com.HenriqueCamarg0.API_HairFlow.repository.UserRepository;
import com.HenriqueCamarg0.API_HairFlow.service.UserService;

import jakarta.validation.Valid;
@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@CrossOrigin
public class AuthController {

    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid UserDTO dto) {
        // Autentica o usuário
        var usernamePassword = new UsernamePasswordAuthenticationToken(dto.getEmail(), dto.getPassword());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        // Recupera os detalhes do usuário
        var userDetails = (UserDetails) auth.getPrincipal();

        // Gera o token JWT
        var token = tokenService.generateToken(userDetails);

        // Retorna o token no DTO de resposta
        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody @Valid RegisterDTO dto) {
        // Verifica se o username já existe
        if (userRepository.findByUsername(dto.getUsername()).isPresent()) {
            return ResponseEntity.badRequest().body("Username já está em uso!");
        }

        // Verifica se o email já existe
        if (userRepository.findByEmail(dto.getEmail()).isPresent()) {
            return ResponseEntity.badRequest().body("Email já está em uso!");
        }

        // Criptografa a senha
        String encryptedPassword = passwordEncoder.encode(dto.getPassword());

        // Cria e salva o novo usuário
        User newUser = new User(dto.getUsername(), dto.getEmail(), encryptedPassword, dto.getRole());
        userRepository.save(newUser);

        return ResponseEntity.ok("Usuário registrado com sucesso!");
    }
}