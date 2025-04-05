package com.HenriqueCamarg0.API_HairFlow.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.HenriqueCamarg0.API_HairFlow.Entity.Appointment;
import com.HenriqueCamarg0.API_HairFlow.dto.AppointmentDTO;
import com.HenriqueCamarg0.API_HairFlow.service.AppointmentService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/appointments")
@AllArgsConstructor
@CrossOrigin
public class AppointmentController {

    private final AppointmentService appointmentService;

    // Método para cadastrar agendamento
    @PostMapping("/new")
    public ResponseEntity<Appointment> cadastrar(@RequestBody AppointmentDTO dto) {
        try {
            System.out.println("Recebendo agendamento: " + dto);
            System.out.println("Data: " + dto.getDate());
            System.out.println("Hora: " + dto.getTime());
            Appointment appointment = appointmentService.cadastrar(dto);
            return ResponseEntity.status(HttpStatus.CREATED).body(appointment);
        } catch (Exception e) {
            System.err.println("Erro: " + e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }
}
