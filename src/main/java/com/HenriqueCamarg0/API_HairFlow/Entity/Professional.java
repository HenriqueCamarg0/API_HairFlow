package com.HenriqueCamarg0.API_HairFlow.Entity;

import java.util.List;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
    private String name; // Nome do profissional

    private String email; // Email do profissional

    private String phone; // Telefone do profissional

    
    @ElementCollection
    @CollectionTable(
        name = "professional_work_days", // Tabela de dias de trabalho
        joinColumns = @JoinColumn(name = "professional_id") // Chave estrangeira para a tabela Profissional
    )
    @Enumerated(EnumType.STRING) // Enumeração para armazenar os dias de trabalho
    @Column(name = "work_day")
    private List<WorkDay> workDays; // Dias de trabalho

    // Relacionamento com agendamentos
    @OneToMany(mappedBy = "professional")
    private List<Appointment> appointments;
}
