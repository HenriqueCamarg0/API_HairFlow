package com.HenriqueCamarg0.API_HairFlow.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.HenriqueCamarg0.API_HairFlow.Entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

} 
