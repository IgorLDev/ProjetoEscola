package com.senai.projeto_escola.domain.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "professores")
public class Professor extends Usuario {

    @Column(nullable = false)
    private String turma;

    @CollectionTable(name = "uc_professores", joinColumns = @JoinColumn(name = "professor_id"))
    @ElementCollection(targetClass = UnidadesCurriculares.class)
    @Enumerated(EnumType.STRING)
    @Column(name = "unidades_curriculares")
    private List<UnidadesCurriculares> unidadesCurriculares;
}
