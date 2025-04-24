package com.HenriqueCamarg0.API_HairFlow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;

import com.HenriqueCamarg0.API_HairFlow.Entity.User;
import com.HenriqueCamarg0.API_HairFlow.config.TokenService;
import com.HenriqueCamarg0.API_HairFlow.dto.LoginResponseDTO;
import com.HenriqueCamarg0.API_HairFlow.dto.RegisterDTO;
import com.HenriqueCamarg0.API_HairFlow.dto.UserDTO;
import com.HenriqueCamarg0.API_HairFlow.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@CrossOrigin
public class AuthController {

    private final UserService userService;
    private final AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid UserDTO dto) {
        // Autentica o usuário usando o UserService
        User user = userService.authenticate(dto); // Usando o UserService

        var usernamePassword = new UsernamePasswordAuthenticationToken(user.getEmail(), dto.getPassword());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        var userDetails = (UserDetails) auth.getPrincipal();
        var token = tokenService.generateToken(userDetails);

        return ResponseEntity.ok(new LoginResponseDTO(token)); // Retorna o token de autenticação
    }
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody @Valid RegisterDTO dto) {
        User registeredUser = userService.register(dto);
        return ResponseEntity.ok(registeredUser); 
    }
}