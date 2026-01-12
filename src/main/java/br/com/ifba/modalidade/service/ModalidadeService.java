/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.modalidade.service;

import br.com.ifba.modalidade.repository.ModalidadeRepository;
import br.com.ifba.modalidade.entity.Modalidade;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ketli
 */
@Service//define o bean de service
public class ModalidadeService implements ModalidadeIService {
    
    @Autowired//faz a injeção de dependencia
    private ModalidadeRepository modalidadeRepository;
    
    @Transactional//gerencia a transação com o banco de dados
    public Modalidade save(Modalidade modalidade){
        return modalidadeRepository.save(modalidade);
    }
    
    @Transactional
    public Modalidade update(Long id, Modalidade modalidadeAtualizada){
        return modalidadeRepository.findById(id).map(entity -> {//verifica se o id existe
            updateData(entity, modalidadeAtualizada);
            return modalidadeRepository.save(entity);
        }).orElseThrow(()-> new RuntimeException("Modalidade não encontrada com id: "+ id));//lança uma exception caso não for encontrado
}
    
    //Método encontrar todos
    public List<Modalidade> findAll(){
        return modalidadeRepository.findAll();    
    }
    //Método buscar por ID
    public Modalidade findById(Long id){//gera uma Exceptioin caso não encontre o ID
        return modalidadeRepository.findById(id).orElseThrow(() -> new RuntimeException("Modalidade não encontrada!"));       
    }
    
    //Método deletar
    @Transactional
    public void delete(Long id){
        modalidadeRepository.deleteById(id);
    }
    
    //Método para Atualizar dados especificos, não é possivel editar o ID por ser único
    private void updateData(Modalidade entity, Modalidade modalidade) {
        entity.setNome(modalidade.getNome()); 
        entity.setDescricao(modalidade.getDescricao());
        entity.setNivelDificuldade(modalidade.getNivelDificuldade());
        entity.setRequisitos(modalidade.getRequisitos());
    }
    
}
