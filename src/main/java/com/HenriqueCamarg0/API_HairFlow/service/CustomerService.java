package com.HenriqueCamarg0.API_HairFlow.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.HenriqueCamarg0.API_HairFlow.Entity.Customer;
import com.HenriqueCamarg0.API_HairFlow.dto.CustomerDTO;
import com.HenriqueCamarg0.API_HairFlow.repository.CustomerRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository Repository;

    //Cadastrar cliente
   public Customer cadastrar(CustomerDTO dto){
        Customer customer = new Customer();
        customer.setName(dto.getName());
        customer.setEmail(dto.getEmail());
        customer.setPhone(dto.getPhone());

        return Repository.save(customer);
   }

     //Lista de clientes cadastrados
     public List<Customer> listar() {
          return Repository.findAll();
     }
}
