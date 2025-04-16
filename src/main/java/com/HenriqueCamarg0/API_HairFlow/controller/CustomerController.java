package com.HenriqueCamarg0.API_HairFlow.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    @PostMapping("/new/customer")
    public ResponseEntity<Customer> cadastrar(@RequestBody CustomerDTO dto) {
        Customer customer = Service.cadastrar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(customer);
    }

    //Lista de clientes cadastrados
    @GetMapping("/customerList")
    public ResponseEntity<List<Customer>> listar() {
        List<Customer> customers = Service.listar();
        return ResponseEntity.ok(customers);
    }

    //Buscar cliente por ID
    @GetMapping("/customer/{id}")
    public ResponseEntity<Customer> buscarPorId(@PathVariable Long id) {
        Customer customer = Service.buscarPorId(id);
        if (customer != null) {
            return ResponseEntity.ok(customer);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //Atualizar cliente
    @PostMapping("/customer/{id}")
    public ResponseEntity<Customer> atualizar(@PathVariable Long id, @RequestBody CustomerDTO dto) {
        Customer customer = Service.atualizar(id, dto);
        if (customer != null) {
            return ResponseEntity.ok(customer);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
