/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.ifba.aluno.service;

import br.com.ifba.aluno.entity.Aluno;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author ricle
 */
public interface AlunoIService {
    //Método para fazer a matricula de alunos
    Aluno matriculaAluno(Aluno novoAluno, Long planoId);
    
     //Método para listar alunos
    List<Aluno> findAll();
    
    //Método para buscar alunos por id
    Optional<Aluno> findById(String cpf);
    
    //método para salvar alunos
    Aluno save(Aluno aluno);
    
     // Método específico para atualização de alunos
    Aluno update(String cpf, Aluno aluno);
    
    //método para deletar alunos pelo id
    void delete(String cpf);
    
    //Verifica se existe um aluno com essa matricula
    boolean existsByMatricula(String matricula);
}
