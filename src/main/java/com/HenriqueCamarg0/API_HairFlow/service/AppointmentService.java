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
    public Appointment cadastrar(AppointmentDTO dto){

        Customer customer = customerRepository.findById(dto.getCustomerId()).orElseThrow(
            () -> new RuntimeException("Cliente não encontrado"));
            
        Professional professional = professionalRepository.findById(dto.getProfessionalId()).orElseThrow(
            () -> new RuntimeException("Profissional não encontrado"));
        
        Appointment appointment = new Appointment();
        appointment.setCustomer(customer);
        appointment.setProfessional(professional);
        appointment.setService(dto.getService());
        appointment.setNotes(dto.getNotes());

        return appointmentRepository.save(appointment);
    }

}
