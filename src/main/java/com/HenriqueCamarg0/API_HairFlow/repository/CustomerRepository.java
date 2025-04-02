package com.HenriqueCamarg0.API_HairFlow.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.HenriqueCamarg0.API_HairFlow.Entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    //Busta cliente pelo nome
    Customer findByName(String name);

    //Busta cliente pelo email
    Customer findByEmail(String email);

    //Busta cliente pelo telefone
    Customer findByPhone(String phone);
} 
