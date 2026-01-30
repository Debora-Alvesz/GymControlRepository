/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.ifba.avaliacaofisica.service;

import br.com.ifba.avaliacaofisica.entity.AvaliacaoFisica;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author João Victor
 */
public interface AvaliacaoFisicaIService {
    //Método para salvar Avaliacão Fisica
    AvaliacaoFisica save(AvaliacaoFisica avaliacaoFisica);
    
    //Método para listar Avaliacões Fisicas
    List<AvaliacaoFisica> findAll();
    
    //Método para buscar Avaliacão Fisica com a matricula informada
    AvaliacaoFisica findByAluno_Matricula(String matricula);
    
    //Método para deletar avaliação do aluno
    void delete(AvaliacaoFisica avaliacaoFisica);
    
    //Método para deletar pela matricula
    void deleteByMatricula(String matricula);
    
    // Método específico para atualização
    AvaliacaoFisica update(String matricula, AvaliacaoFisica avaliacaoFisica);
    
    // Método para calcular IMC
    float calcularImc(int altura, float peso);
    
    // Método para listar as avaliações fisicas de um dia especifico
    List<AvaliacaoFisica> findByDataAvaliacao(LocalDate dataAvaliacao);
    
    
}
