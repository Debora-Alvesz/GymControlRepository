/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.ifba.modalidade.service;

import br.com.ifba.usuario.entity.Usuario;
import java.util.List;
import java.util.Optional;
import br.com.ifba.modalidade.entity.Modalidade;

/**
 *
 * @author ketli
 */
public interface ModalidadeIService {
    
    //metodo para salvar modalidade
    Modalidade save(Modalidade modalidade);
    
    //Método atualizar 
    Modalidade update(Long id, Modalidade modalidade);
    
    //MÉtodo para listar todos
    List<Modalidade> findAll();
    
    //Método para buscar modalidade por id
    Modalidade findById(Long id);
    
    //método para deletar modalidade pelo id
    void delete(Long id);
 
}
