package br.com.ifba.instrutor.service;

import br.com.ifba.instrutor.entity.Instrutor;

import java.util.List;

public interface I_InstrutorService {

    Instrutor salvar(Instrutor instrutor);

    List<Instrutor> listarTodos();

    Instrutor buscarPorId(Long id);

    Instrutor atualizar(Long id, Instrutor instrutor);

    void deletar(Long id);
}
