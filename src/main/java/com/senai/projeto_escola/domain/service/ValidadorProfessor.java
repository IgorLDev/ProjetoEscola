package com.senai.projeto_escola.domain.service;

import com.senai.projeto_escola.application.dto.ProfessorDto;
import org.springframework.stereotype.Component;

@Component
public class ValidadorProfessor {
    public void validar(ProfessorDto professorDto){
        if (professorDto.idade()<0){
            throw new IllegalArgumentException("Idade inválida");
        }
        if (professorDto.unidadesCurriculares() == null || professorDto.unidadesCurriculares().size() <2){
            throw new IllegalArgumentException("Professor deve ter no mínimo 2 unidades curriculares");
        }

    }
}
