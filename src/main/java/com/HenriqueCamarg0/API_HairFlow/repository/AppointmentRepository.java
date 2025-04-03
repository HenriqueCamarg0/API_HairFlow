package com.HenriqueCamarg0.API_HairFlow.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.HenriqueCamarg0.API_HairFlow.Entity.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

}
