package com.HenriqueCamarg0.API_HairFlow.dto;

import com.HenriqueCamarg0.API_HairFlow.Entity.UserRole;

import lombok.Data;

@Data
public class UserDTO {
    private String username;
    private String email;
    private String password;
    private UserRole role; // Adicionando o campo de papel do usuário (ROLE_CUSTOMER ou ROLE_ADMIN)
}
