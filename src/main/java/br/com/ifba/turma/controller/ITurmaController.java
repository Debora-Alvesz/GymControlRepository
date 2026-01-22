package br.com.ifba.turma.controller;

import br.com.ifba.turma.entity.Turma;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITurmaController {

    Turma save(Turma turma);

    Turma update(String id, Turma turma);

    void delete(String id);

    Turma findById(String id);

    List<Turma> findAll();
}
