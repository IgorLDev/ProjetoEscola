package com.senai.projeto_escola.application.dto;

import com.senai.projeto_escola.domain.entity.Coordenador;

import java.util.List;

public record CoordenadorDto(Long id, String nome, int idade, List<ProfessorDto> equipe) {

}
