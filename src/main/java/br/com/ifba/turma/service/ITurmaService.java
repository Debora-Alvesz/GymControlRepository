package br.com.ifba.turma.service;

import br.com.ifba.turma.entity.Turma;

import java.util.List;


public interface ITurmaService {

   Turma save(Turma turma);

   List<Turma> findAll();

    Turma findById(Long id);

    Turma update(String id, Turma turma);

    void delete(Long id);

}
