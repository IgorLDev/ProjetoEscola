package com.senai.projeto_escola.application.service;

import com.senai.projeto_escola.application.dto.ProfessorDto;
import com.senai.projeto_escola.domain.entity.Professor;
import com.senai.projeto_escola.domain.repository.ProfessorRepository;
import com.senai.projeto_escola.domain.service.ValidadorCoordenador;
import com.senai.projeto_escola.domain.service.ValidadorProfessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessorService {
    @Autowired
    private ProfessorRepository professorRepo;
    @Autowired
    private ValidadorProfessor validadorProfessor;

    public void salvar(ProfessorDto professorDto){
        validadorProfessor.validar(professorDto);
        Professor professor = new Professor();
        professor.setNome(professorDto.nome());
        professor.setIdade(professorDto.idade());
        professor.setTurma(professorDto.turma());
        professor.setUnidadesCurriculares(professorDto.unidadesCurriculares());
        professorRepo.save(professor);
    }

    public List<ProfessorDto> listar() {
        return professorRepo.findAll().stream().map(p -> new ProfessorDto(
                p.getId(),
                p.getNome(),
                p.getIdade(),
                p.getTurma(),
                p.getUnidadesCurriculares()
        )).toList();
    }

    public Optional<ProfessorDto> buscarPorId(Long id){
        return professorRepo.findById(id).map(p -> new ProfessorDto(
                p.getId(),
                p.getNome(),
                p.getIdade(),
                p.getTurma(),
                p.getUnidadesCurriculares()
        ));
    }

    public boolean atualizar(Long id, ProfessorDto professorDto){
        validadorProfessor.validar(professorDto);
        return professorRepo.findById(id).map(p -> {
            p.setNome(professorDto.nome());
            p.setIdade(professorDto.idade());
            p.setTurma(professorDto.turma());
            p.setUnidadesCurriculares(professorDto.unidadesCurriculares());
            professorRepo.save(p);
            return true;
        }).orElse(false);
    }

    public boolean deletar(Long id){
        if (professorRepo.existsById(id)){
            professorRepo.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
