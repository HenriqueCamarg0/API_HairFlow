package com.HenriqueCamarg0.API_HairFlow.dto;

import lombok.Data;

public class LoginResponseDTO {
    private final String token;

    public LoginResponseDTO(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}
