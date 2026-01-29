/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.manutencao.service;

import br.com.ifba.manutencao.entity.Manutencao;
import br.com.ifba.manutencao.repository.ManutencaoRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 *
 * @author ricley
 */
@Service//Marca a classe como um bean de serviço no Spring
@RequiredArgsConstructor//o lombok gera o construtor para os campos "final"
@Slf4j//Responsavel pelo logger
public class ManutencaoService implements ManutencaoIService{

    public final ManutencaoRepository manutencaoRepository;
    
    //Salva uma nova manutencao
    @Override
    public Manutencao save(Manutencao manutencao) {
        //logger de informacao
        log.info("[SERVICE] ManutencaoService - Reportando problema no equipamento: {}", manutencao.getNomeEquipamento());
        
        //Atualiza o status da manutencao
        manutencao.setStatus("PENDENTE");
        
        //logger de informacao
        log.info("[SERVICE] ManutencaoService - Manutenção registrada com sucesso.");
        
        //Salva a manutencao no banco de dados
        return manutencaoRepository.save(manutencao);  
    }

    //Atualiza uma manutencao
     @Override
    public Manutencao update(Manutencao manutencao) {
        //logger de informacao
        log.info("[SERVICE] ManutencaoService - Atualizando manutencao ID: {}", manutencao.getId());
        
        //Verifica sea manutencao existe 
        if(!manutencaoRepository.existsById(manutencao.getId())){
            log.error("[SERVICE] ManutencaoService - Manutenção não encontrada para atualização");
            throw new RuntimeException("Manutencao nao encontrada para a atualizacao");
        }
        //Salva no Repository
        return manutencaoRepository.save(manutencao);
    }

    //Exclui uma manutencao
    @Override
    public void delete(Long id) {
        
        log.info("[SERVICE] ManutencaoService - Excluindo manutencao Id: {}", id);
        
        //Verificacao simples
        if(!manutencaoRepository.existsById(id)){
            log.error("[SERVICE] ManutencaoService - Manutenção não encontrada para exclusão");
            throw new RuntimeException("Manutencao nao encontrada para a exclusao");
        }
        
        //Deleta a manutencao
        manutencaoRepository.deleteById(id);
    }

    //Busca a manutencao pelo ID
    @Override
    public Manutencao findById(Long id) {
        log.info("[SERVICE] ManutencaoService - Buscando manutenção ID: {}", id);

        return manutencaoRepository.findById(id)
                .orElseThrow(() -> {
                log.error("[SERVICE] ManutencaoService - Manutenção não encontrada. ID: {}", id);
                return new RuntimeException("Manutenção não encontrada");
           });
    }

    /**
     * Retorna a lista de todas as manutenções cadastradas no sistema.
     * @return 
     */
    @Override
    public List<Manutencao> findAll() {
         log.info("[SERVICE] ManutencaoService - Listando todas as manutenções");
        return manutencaoRepository.findAll();
    }
    
    //Finaliza uma manutencao existente
    @Override
    public Manutencao finalizarManutencao(Long id) {
        
        log.info("[SERVICE] ManutencaoService - Finalizando manutencao ID: {}", id);
        
        // Busca a manutenção pelo ID.
        // Caso não exista, lança uma exceção.
         Manutencao manutencao = manutencaoRepository.findById(id)
                .orElseThrow(() -> {
                   log.error("[SERVICE] ManutencaoService - Manutenção não encontrada para finalização. ID: {}", id);
                    return new RuntimeException("Manutenção não encontrada");
                });

        //Atualiza o status da manutencao
        manutencao.setStatus("RESOLVIDO");
        
        //logger de informacao
        log.info("[SERVICE] ManutencaoService - Manutenção finalizada com sucesso. ID: {}", id);
        
        //Salva a atualização no banco
        return manutencaoRepository.save(manutencao);

    }


   
    
}
