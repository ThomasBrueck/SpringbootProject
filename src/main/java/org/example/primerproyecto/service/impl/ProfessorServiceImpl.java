package org.example.primerproyecto.service.impl;


import org.example.primerproyecto.entity.Professor;
import org.example.primerproyecto.repository.ProfessorRepository;
import org.example.primerproyecto.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorServiceImpl implements ProfessorService{

    @Autowired
    private ProfessorRepository professorRepository;


    @Override
    public List<Professor> getProfessors() {
        return professorRepository.findAll();
    }
}
