/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.ifba.manutencao.service;

import br.com.ifba.manutencao.entity.Manutencao;
import java.util.List;

/**
 *
 * @author ricley
 */
public interface ManutencaoIService {
    
    //método para salvar um novo problema de manutencao
    Manutencao save(Manutencao manutencao);
    
    //Metodo que apos a manutencao, altera o status para resolvido
    Manutencao finalizarManutencao(Long id);
    
    //Metodo para listar as manutencoes feitas
    List<Manutencao> findAll();
}
