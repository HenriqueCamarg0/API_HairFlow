package com.HenriqueCamarg0.API_HairFlow.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.HenriqueCamarg0.API_HairFlow.Entity.Customer;
import com.HenriqueCamarg0.API_HairFlow.dto.CustomerDTO;
import com.HenriqueCamarg0.API_HairFlow.service.CustomerService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/HeirFlow")
@AllArgsConstructor
@CrossOrigin
public class CustomerController {
    
    private final CustomerService Service;

    //Cadastrar cliente
    @PostMapping("/customer")
    public ResponseEntity<Customer> cadastrar(@RequestBody CustomerDTO dto) {
        Customer customer = Service.cadastrar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(customer);
    }

    @GetMapping("/test")
public ResponseEntity<String> test() {
    return ResponseEntity.ok("API is working!");
}
}
