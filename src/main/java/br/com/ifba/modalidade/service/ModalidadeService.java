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
    
    private static final org.slf4j.Logger logger =
            org.slf4j.LoggerFactory.getLogger(ModalidadeService.class);
    
    @Autowired//faz a injeção de dependencia
    private ModalidadeRepository modalidadeRepository;
    
    @Transactional//gerencia a transação com o banco de dados
    public Modalidade save(Modalidade modalidade){
        //logs de informacoes
        logger.info("[SERVICE] ModalidadeService - Iniciando cadastro de modalidade. Nome: {}", modalidade.getNome());
        
        logger.info("[SERVICE] ModalidadeService - Modalidade cadastrada com sucesso.");
        return modalidadeRepository.save(modalidade);
    }
    
    @Transactional
    public Modalidade update(Long id, Modalidade modalidadeAtualizada){
        //logs de informacoes
        logger.info("[SERVICE] ModalidadeService - Iniciando atualização da modalidade. ID: {}", id);
        
        return modalidadeRepository.findById(id)
        .map(entity -> {
            // Log de sucesso (achou a modalidade)
            logger.info("[SERVICE] ModalidadeService - Modalidade encontrada. Atualizando dados. ID: {}", id);

            updateData(entity, modalidadeAtualizada);

            logger.info("[SERVICE] ModalidadeService - Modalidade atualizada com sucesso. ID: {}", id);
            return modalidadeRepository.save(entity);
        })
        .orElseThrow(() -> {
            // Log de erro (não encontrou)
            logger.error("[SERVICE] ModalidadeService - Modalidade não encontrada para atualização. ID: {}", id);
            return new RuntimeException("Modalidade não encontrada com id: " + id);
        });
}
    
    //Método encontrar todos
    public List<Modalidade> findAll(){
        
        logger.info("[SERVICE] ModalidadeService - Listando todas as modalidades");
        
        return modalidadeRepository.findAll();    
    }
    //Método buscar por ID
    public Modalidade findById(Long id){
        
        logger.info("[SERVICE] ModalidadeService - Buscando modalidade por ID: {}", id);
        
        return modalidadeRepository.findById(id)
                .orElseThrow(() -> {
                    logger.error("[SERVICE] ModalidadeService - Modalidade não encontrada. ID: {}", id);
                    return new RuntimeException("Modalidade não encontrada!");//gera uma Exceptioin caso não encontre o ID 
                });
    }
    
    //Método deletar
    @Transactional
    public void delete(Long id){
        logger.info("[SERVICE] ModalidadeService - Solicitação de exclusão da modalidade. ID: {}", id);

            if (!modalidadeRepository.existsById(id)) {
                logger.error("[SERVICE] ModalidadeService - Tentativa de exclusão de modalidade inexistente. ID: {}", id);
                throw new RuntimeException("Modalidade não encontrada para exclusão.");
        }

            modalidadeRepository.deleteById(id);
            logger.info("[SERVICE] ModalidadeService - Modalidade excluída com sucesso. ID: {}", id);
    }
    
    //Método para Atualizar dados especificos, não é possivel editar o ID por ser único
    private void updateData(Modalidade entity, Modalidade modalidade) {
        entity.setNome(modalidade.getNome()); 
        entity.setDescricao(modalidade.getDescricao());
        entity.setNivelDificuldade(modalidade.getNivelDificuldade());
        entity.setRequisitos(modalidade.getRequisitos());
    }
    
}
