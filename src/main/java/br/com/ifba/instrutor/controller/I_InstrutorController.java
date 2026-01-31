package br.com.ifba.instrutor.controller;

import br.com.ifba.instrutor.entity.Instrutor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface I_InstrutorController {

    ResponseEntity<Instrutor> salvar(@RequestBody Instrutor instrutor);

    ResponseEntity<List<Instrutor>> listarTodos();

    ResponseEntity<Instrutor> buscarPorId(@PathVariable Long id);

    ResponseEntity<Instrutor> atualizar(@PathVariable Long id, @RequestBody Instrutor instrutor);

    ResponseEntity<Void> deletar(@PathVariable Long id);
}
