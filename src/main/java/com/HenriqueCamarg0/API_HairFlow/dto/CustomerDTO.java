package com.HenriqueCamarg0.API_HairFlow.dto;

import lombok.Data;

@Data
public class CustomerDTO {

    private Long id; // ID do cliente
    private String name; // Nome do cliente
    private String email; // Email do cliente
    private String phone; // Telefone do cliente
}
