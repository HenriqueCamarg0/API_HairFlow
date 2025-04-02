package com.HenriqueCamarg0.API_HairFlow.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class AppointmentDTO {
    private Long id;
    private CustomerDTO customer;
    private ProfessionalDTO professional;
    private String service; // Exemplo: "Corte de cabelo", "Coloração", etc.
    private LocalDateTime dateTime;
}
