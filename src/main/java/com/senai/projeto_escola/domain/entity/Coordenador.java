package com.senai.projeto_escola.domain.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Coordenador extends Usuario{

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "coordenador_equipe",
            joinColumns = @JoinColumn(name = "coordenador_id"),
            inverseJoinColumns = @JoinColumn(name = "professor_id")
    )
    private List<Professor> equipeProfessores;
}
