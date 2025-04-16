package com.HenriqueCamarg0.API_HairFlow.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Entity
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "professional_id", nullable = false)
    private Professional professional;

    private LocalDate date; // Data do agendamento
    private LocalTime time; // Data e hora do agendamento
    
    private String service; // Tipo de serviço (pode usar ENUM futuramente)

    private Status status = Status.PENDING; // Status do agendamento (pendente, confirmado, etc.)

    private String notes; // Observações adicionais
}
