package com.HenriqueCamarg0.API_HairFlow.Entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name = "Profissional")
// @Table(name = "Professional")
public class Professional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotNull
    private String name; 

    private String expertise; // Exemplo: "Cortes", "Coloração", etc.

    private Boolean isAvailable; // Indica se o profissional está disponível para agendamentos

    // Relacionamento com agendamentos
    @OneToMany(mappedBy = "professional")
    private List<Appointment> appointments;
}
