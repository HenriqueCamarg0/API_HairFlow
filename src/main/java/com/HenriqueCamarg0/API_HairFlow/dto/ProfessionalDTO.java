package com.HenriqueCamarg0.API_HairFlow.dto;

import com.HenriqueCamarg0.API_HairFlow.Entity.WorkDay;
import java.util.List;
import lombok.Data;

@Data
public class ProfessionalDTO {
    private Long id;
    private String name; // Name of the professional
    private List<WorkDay> workDays; // Dias de trabalho
    private String email;
    private String phone;
}
