/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.ifba.gym.service;

import br.com.ifba.gym.entity.Plano;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author João Victor
 */
public interface PlanoIService {
    //método para salvar planos
    Plano save(Plano plano);
    
    //Método para listar planos
    List<Plano> findAll();
    
    //Método para buscar planos por id
    Optional<Plano> findById(Long id);
    
    //método para deletar plano pelo id
    void delete(Long id);
    
    // Método específico para atualização
    Plano update(Long id, Plano plano);
}
