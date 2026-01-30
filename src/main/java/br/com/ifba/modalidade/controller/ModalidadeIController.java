/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.ifba.modalidade.controller;

import br.com.ifba.modalidade.entity.Modalidade;
import java.util.List;

/**
 *
 * @author ketli
 */
public interface ModalidadeIController {
    
   void saveModalidade(String nome, String descricao, String nivel, String requisitos);
  
   void updateModalidade(Long id, String nome, String descricao, String nivel, String requisitos);
  
   List<Modalidade> findAll();
    
   void delete(Long id);
    
   Modalidade findById(Long id);
    
}
