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
        System.out.println("Recebendo requisição de agendamento: " + dto);
        Appointment appointment = appointmentService.cadastrar(dto);
        System.out.println("Agendamento criado com sucesso: " + appointment);
        return ResponseEntity.status(HttpStatus.CREATED).body(appointment);
    }
}
