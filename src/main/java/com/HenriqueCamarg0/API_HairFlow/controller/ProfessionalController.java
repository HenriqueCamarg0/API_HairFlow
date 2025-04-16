package com.HenriqueCamarg0.API_HairFlow.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    //Novo profissional
    @PostMapping("/new/professional")
    public ResponseEntity<Professional> cadastrar(@RequestBody ProfessionalDTO dto) {
        Professional professional = service.cadastrar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(professional);
    }

    //Listar de profissionais
    @GetMapping("/list/professionals")
    public ResponseEntity<Iterable<Professional>> listarProfissionais() {
        Iterable<Professional> profissionais = service.listarProfissionais();
        return ResponseEntity.ok(profissionais);
    }

    //Buscar profissional por ID
    @RequestMapping("/find/professional/{id}")
    public ResponseEntity<Professional> buscarPorId(@PathVariable Long id) {
        Professional professional = service.buscarPorId(id);
        if (professional != null) {
            return ResponseEntity.ok(professional);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    //Atualizar profissional
    @PostMapping("/update/professional/{id}")
    public ResponseEntity<Professional> atualizar(@PathVariable Long id, @RequestBody ProfessionalDTO dto) {
        Professional professional = service.atualizar(id, dto);
        if (professional != null) {
            return ResponseEntity.ok(professional);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    //Deletar profissional
    @RequestMapping("/delete/professional/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}   
