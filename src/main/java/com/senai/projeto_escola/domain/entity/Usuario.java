package com.senai.projeto_escola.domain.entity;

import jakarta.persistence.*;
import lombok.Data;

@MappedSuperclass
@Data
abstract class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false)
    private int idade;
}

