package com.HenriqueCamarg0.API_HairFlow.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import com.HenriqueCamarg0.API_HairFlow.Entity.Customer;
import com.HenriqueCamarg0.API_HairFlow.Entity.Professional;
import com.HenriqueCamarg0.API_HairFlow.Entity.Status;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AppointmentDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @NotNull(message = "ID do cliente é obrigatório")
    private Long customerId;
    
    @NotNull(message = "ID do profissional é obrigatório")
    private Long professionalId;
    
    @NotBlank(message = "Serviço é obrigatório")
    private String service;
    
    private LocalDate date; // Data do agendamento
    private LocalTime time; // Data e hora do agendamento

    private Status status = Status.PENDING; // Status do agendamento (pendente, confirmado, etc.)
    private String notes; // Observações adicionais

}
