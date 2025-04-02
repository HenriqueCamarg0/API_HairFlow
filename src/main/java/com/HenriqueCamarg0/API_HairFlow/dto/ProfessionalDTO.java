package com.HenriqueCamarg0.API_HairFlow.dto;

import java.util.List;

import com.HenriqueCamarg0.API_HairFlow.Entity.Appointment;

import lombok.Data;

@Data
public class ProfessionalDTO {
    private Long id;
    private String name; // Name of the professional
    private String expertise; // serviços do profissional
    private Boolean isAvailable; // Disponibilidade do profissional
    private List<Appointment> appointments; // Lista de agendamentos do profissional
}
