/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package br.com.ifba.exercicio.controller;

import br.com.ifba.exercicio.entity.Exercicio;
import java.util.List;

/**
 *
 * @author Débora Alves
 */
public interface ExercicioIController {

    // Lista todos os exercícios para alimentar a tabela
    List<Exercicio> findAll();

    // Salva um novo exercício
    Exercicio save(Exercicio exercicio);

    // Atualiza um exercício existente
    Exercicio update( Exercicio exercicio);

    // Deleta um exercício pelo ID
    void delete(Long id);

    // Busca um exercício pelo ID
    Exercicio findById(Long id);
    
}
