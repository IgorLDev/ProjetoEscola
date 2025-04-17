package com.senai.projeto_escola.application.dto;

import com.senai.projeto_escola.domain.entity.UnidadesCurriculares;
import lombok.Data;

import java.util.List;

public record ProfessorDto(Long id, String nome, int idade, String turma, List<UnidadesCurriculares> unidadesCurriculares) {
}
