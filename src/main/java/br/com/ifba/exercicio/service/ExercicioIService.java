/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package br.com.ifba.exercicio.service;

import br.com.ifba.exercicio.entity.Exercicio;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Débora Alves
 */
public interface ExercicioIService {

    // Método para salvar um exercício
    Exercicio save(Exercicio exercicio);
    
    // Método para atualizar um exercício
    Exercicio update(Exercicio exercicio);
    
    // Método para deletar um exercício
    void delete(Long id);
    
    // Método para listar todos os exercícios
    List<Exercicio> findAll();
    
    // Método para buscar um exercício pelo seu ID
    Optional<Exercicio> findById(Long id);
    
   
}
