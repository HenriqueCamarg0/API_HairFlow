package com.HenriqueCamarg0.API_HairFlow.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.HenriqueCamarg0.API_HairFlow.Entity.Professional;
import com.HenriqueCamarg0.API_HairFlow.dto.ProfessionalDTO;
import com.HenriqueCamarg0.API_HairFlow.service.ProfessionalService;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/Professional")
@AllArgsConstructor
@CrossOrigin
public class ProfessionalController {

    private final ProfessionalService service;

    @PostMapping("/new/professional")
    public ResponseEntity<Professional> cadastrar(@RequestBody ProfessionalDTO dto) {
        Professional professional = service.cadastrar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(professional);
    }
    
}   
