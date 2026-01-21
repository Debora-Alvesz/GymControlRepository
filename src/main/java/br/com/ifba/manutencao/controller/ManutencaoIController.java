/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.ifba.manutencao.controller;

import br.com.ifba.manutencao.entity.Manutencao;
import java.util.List;

/**
 *
 * @author ricley
 */
public interface ManutencaoIController {
    //Salva uma nova manutencao
    Manutencao save(Manutencao manutencao);
    
    //Lista todas as manutencoes
    List<Manutencao> findAll();
    
    //Atualiza manutencao
    Manutencao update(Manutencao manutencao);
    
    //Exclui uma manutencao pelo ID
    void delete(Long id);
    
    //Busca uma manutencao pelo ID
    Manutencao findById(Long id);
    
    //Metodo que reporta um problema de Manutencao
    Manutencao reportarProblema(String equipamento, String problema);
    
    //Maarca uma manutencao como resolvida
    Manutencao marcarComoResolvido(Long id);
}
