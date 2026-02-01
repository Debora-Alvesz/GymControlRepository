/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.ifba.plano.service;

import br.com.ifba.plano.entity.Plano;
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
    
    //método para buscar pelo nome
    Plano findByNome(String nome);
    
    //método para deletar plano pelo id
    void delete(Long id);
    
    // Método específico para atualização
    Plano update(Long id, Plano plano);
}
