package com.senai.projeto_escola.application.dto;

import java.util.List;

public record CoordenadorDto(Long id, String nome, int idade, List<ProfessorDto> equipe) {

}
