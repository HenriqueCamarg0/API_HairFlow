package com.HenriqueCamarg0.API_HairFlow.service;

import org.springframework.stereotype.Service;

import com.HenriqueCamarg0.API_HairFlow.Entity.Appointment;
import com.HenriqueCamarg0.API_HairFlow.Entity.Customer;
import com.HenriqueCamarg0.API_HairFlow.Entity.Professional;
import com.HenriqueCamarg0.API_HairFlow.dto.AppointmentDTO;
import com.HenriqueCamarg0.API_HairFlow.repository.AppointmentRepository;
import com.HenriqueCamarg0.API_HairFlow.repository.CustomerRepository;
import com.HenriqueCamarg0.API_HairFlow.repository.ProfessionalRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AppointmentService {

    private final ProfessionalRepository professionalRepository;
    private final CustomerRepository customerRepository;
    private final AppointmentRepository appointmentRepository;

    //Cadastrar agendamento
    public Appointment cadastrar(AppointmentDTO dto) {
        System.out.println("Buscando cliente com ID: " + dto.getCustomerId());
        Customer customer = customerRepository.findById(dto.getCustomerId())
            .orElseThrow(() -> new RuntimeException("Cliente não encontrado: " + dto.getCustomerId()));

        System.out.println("Buscando profissional com ID: " + dto.getProfessionalId());
        Professional professional = professionalRepository.findById(dto.getProfessionalId())
            .orElseThrow(() -> new RuntimeException("Profissional não encontrado: " + dto.getProfessionalId()));

        Appointment appointment = new Appointment();
        appointment.setCustomer(customer);
        appointment.setProfessional(professional);
        appointment.setService(dto.getService());
        appointment.setDate(dto.getDate());
        appointment.setTime(dto.getTime());
        appointment.setStatus(dto.getStatus());
        appointment.setNotes(dto.getNotes());

        System.out.println("Salvando agendamento: " + appointment);
        return appointmentRepository.save(appointment);
    }

}
