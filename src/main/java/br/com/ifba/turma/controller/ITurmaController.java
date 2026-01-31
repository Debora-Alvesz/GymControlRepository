package br.com.ifba.turma.controller;

import br.com.ifba.turma.entity.Turma;
import org.springframework.stereotype.Repository;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public interface ITurmaController {

    ResponseEntity<Turma> salvar(@RequestBody Turma turma);

    ResponseEntity<Turma> buscarPorId(@PathVariable Long id);

    ResponseEntity<List<Turma>> listarTodas();

    ResponseEntity<Turma> atualizar(
            @PathVariable Long id,
            @RequestBody Turma turma);

    ResponseEntity<Void> excluir(@PathVariable Long id);
}
