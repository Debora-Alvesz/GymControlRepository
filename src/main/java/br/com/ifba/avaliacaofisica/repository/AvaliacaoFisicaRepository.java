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
    
    // Método para listar as avaliações fisicas de um dia especifico
    List<AvaliacaoFisica> findByDataAvaliacao(LocalDate dataAvaliacao);
    
    //Método para buscar Avaliacão Fisica com a matricula informada
    Optional<AvaliacaoFisica> findByAluno_Matricula(String matricula);
    
    // Verifica se existe Avaliação Física para a matrícula informada
    boolean existsByAlunoMatricula(String matricula);
}
