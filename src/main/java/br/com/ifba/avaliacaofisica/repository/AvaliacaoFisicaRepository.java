/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.ifba.avaliacaofisica.repository;

import br.com.ifba.avaliacaofisica.entity.AvaliacaoFisica;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author João Victor
 */

@Repository
public interface AvaliacaoFisicaRepository extends JpaRepository<AvaliacaoFisica, Long>{
    
    //Método para salvar Avaliacão Fisica
    @Override
    AvaliacaoFisica save(AvaliacaoFisica avaliacaoFisica);
    
    //Método para listar Avaliacões Fisicas
    @Override
    List<AvaliacaoFisica> findAll();
    
    //Método para buscar Avaliacão Fisica por matricula
    Optional<AvaliacaoFisica> findAlunoByMatricula(String matricula);
    
    //Método para deletar avaliação pela matricula do aluno
    void deleteByAlunoMatricula(String matricula);
    
    // Método específico para atualização
    AvaliacaoFisica update(String matricula, AvaliacaoFisica avaliacaoFisica);

    // Método para listar as avaliações fisicas de um dia especifico
    List<AvaliacaoFisica> findByDataAvaliacao(LocalDate dataAvaliacao);
    
    //Método para buscar se existe Avaliacão Fisica com aquela matricula
    Optional<AvaliacaoFisica> findByAlunoMatricula(String matricula);
    
    // Verifica se existe Avaliação Física para a matrícula informada
    boolean existsByAlunoMatricula(String matricula);
}
