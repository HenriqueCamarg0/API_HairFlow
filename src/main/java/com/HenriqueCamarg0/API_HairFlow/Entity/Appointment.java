package com.HenriqueCamarg0.API_HairFlow.Entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Agendamento")
// @Table(name = "Appointment")
public class Appointment {
    //Entity class for Agendamento

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private Customer customer;

    private Professional professional;

    private String service; // Exemplo: "Corte de cabelo", "Coloração", etc.

    private LocalDateTime dateTime; // Data e hora do agendamento

}
