/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.modalidade.controller;

import br.com.ifba.modalidade.service.ModalidadeService;
import br.com.ifba.modalidade.entity.Modalidade;
import java.util.List;
import javax.swing.JOptionPane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 *
 * @author ketli
 */
@Controller//Indica ao Spring que esta classe é um bean e pode ser injetada em outras classes
public class ModalidadeController {
    
    @Autowired//O Spring injeta automaticamente a instância de ModalidadeService aqui
    private ModalidadeService modalidadeService;
    
    //Método responsável por receber os dados da View e coordenar o salvamento
    public void saveModalidade(String nome, String descricao, String nivel, String requisitos){
    try{
        //verifica se o campo está nulo ou apenas com espaços em branco
        if(nome == null || nome.trim().isEmpty()){
            throw new RuntimeException("O nome é obrigatório!");
        }
        
        // Instancia o objeto da entidade Modalidade
        Modalidade modalidade = new Modalidade();
        modalidade.setNome(nome.trim());//atribui um novo nome na modalidade
        modalidade.setDescricao(descricao.trim());// -- nova descrição
        modalidade.setNivelDificuldade(nivel.trim());// -- nova dificuldade
        modalidade.setRequisitos(requisitos.trim());// -- novos requisitos
        
        //Chama a camada de serviço para persistir os dados no banco de dados
        modalidadeService.save(modalidade);
        
        //exibe um feedback visual de sucesso para o usuário no JFrame
        JOptionPane.showMessageDialog(null, "Modalidade " + modalidade.getNome() + "cadastrada com sucesso!");
    }
    catch(Exception e){
        //Captura qualquer erro (incluindo as exceções lançadas no Service) e mostra ao usuário
        JOptionPane.showMessageDialog(null, "Erro ao salvar: " + e.getMessage());
        
    }  
}
    // Método utilizado para buscar todos os registros e exibir em componentes
    public List<Modalidade> findAll(){
        return modalidadeService.findAll();
    }
    // Método para excluir um registro através do ID
    public void delete(Long id){
        modalidadeService.delete(id);  
    }
    // Método para buscar uma modalidade específica pelo ID
    public Modalidade findById(Long id){
        return modalidadeService.findById(id);
    }
    
   
    
}
