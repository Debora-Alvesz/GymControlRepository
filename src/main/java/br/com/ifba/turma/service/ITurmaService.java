package br.com.ifba.turma.service;

import br.com.ifba.turma.entity.Turma;

import java.util.List;


public interface ITurmaService {

   Turma salvar(Turma turma);

   List<Turma> listarTodas();

    Turma buscarPorId(Long id);
    
    void deletar(Long id);

}
