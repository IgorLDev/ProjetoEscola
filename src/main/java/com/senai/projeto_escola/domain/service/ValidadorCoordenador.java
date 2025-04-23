package com.senai.projeto_escola.domain.service;

import com.senai.projeto_escola.application.dto.CoordenadorDto;
import org.springframework.stereotype.Component;

@Component
public class ValidadorCoordenador {
    public void validar(CoordenadorDto coordenadorDto){
        if (coordenadorDto.idade()<0) {
            throw new IllegalArgumentException("Idade inválida");
        }
        if (coordenadorDto.equipe() == null || coordenadorDto.equipe().size()<3){
            throw new IllegalArgumentException("Coordenador deve ter no mínimo 3 professores.");
        }
    }
}
