package com.HenriqueCamarg0.API_HairFlow.service;

import org.springframework.stereotype.Service;

import com.HenriqueCamarg0.API_HairFlow.Entity.Professional;
import com.HenriqueCamarg0.API_HairFlow.dto.ProfessionalDTO;
import com.HenriqueCamarg0.API_HairFlow.repository.ProfessionalRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProfessionalService {

    private final ProfessionalRepository repository;

    //Cadastrar profissional
    public Professional cadastrar(ProfessionalDTO dto){
        Professional professional = new Professional();
        professional.setName(dto.getName()); // Nome do profissional
        professional.setEmail(dto.getEmail()); // Email do profissional
        professional.setPhone(dto.getPhone()); // Telefone do profissional
        professional.setWorkDays(dto.getWorkDays()); // Dias de trabalho do profissional

        return repository.save(professional);
    }

    //Listar de profissionais   
    public Iterable<Professional> listarProfissionais() {
        return repository.findAll();
    }

    //Buscar profissional por ID
    public Professional buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    //Atualizar profissional
    public Professional atualizar(Long id, ProfessionalDTO dto) {
        Professional professional = repository.findById(id).orElse(null);
        if (professional != null) {
            professional.setName(dto.getName());
            professional.setEmail(dto.getEmail());
            professional.setPhone(dto.getPhone());
            professional.setWorkDays(dto.getWorkDays());
            return repository.save(professional);
        }
        return null;
    }

    //Deletar profissional
    public void deletar(Long id) {
        Professional professional = repository.findById(id).orElse(null);
        if (professional != null) {
            repository.delete(professional);
        }
    }
}
