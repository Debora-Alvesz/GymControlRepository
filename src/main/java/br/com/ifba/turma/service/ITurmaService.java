package br.com.ifba.turma.service;

import br.com.ifba.turma.entity.Turma;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITurmaService {

   Turma save(Turma turma);

   List<Turma> findAll();

    Turma findById(Long id);

    Turma update(String id, Turma turma);

    void delete(Long id);

}
