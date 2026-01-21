/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.manutencao.controller;

import br.com.ifba.manutencao.entity.Manutencao;
import br.com.ifba.manutencao.service.ManutencaoIService;
import java.time.LocalDate;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

/**
 *
 * @author ricley
 */
@Controller
@RequiredArgsConstructor
public class ManutencaoController implements ManutencaoIController{
    
    private final ManutencaoIService manutencaoService;
    
    //Salvar
    @Override
    public Manutencao save(Manutencao manutencao) {
        //Manda o objeto pro service salvar
        return manutencaoService.save(manutencao);
    }

    //Listar todas
    @Override
    public List<Manutencao> findAll() {
        //Manda pro Service listar todas as manutencoes
        return manutencaoService.findAll();
    }

    //Atualizar
    @Override
    public Manutencao update(Manutencao manutencao) {
        //Manda pro Service fazer a atualizacao
        return manutencaoService.update(manutencao);
    }

    //Deletar
    @Override
    public void delete(Long id) {
        manutencaoService.delete(id);
    }

    //Buscar pelo ID
    @Override
    public Manutencao findById(Long id) {
        return manutencaoService.findById(id);
    }
    
    
    //Reporta um problema de Manutencao
    @Override
    public Manutencao reportarProblema(String equipamento, String problema) {

        if (equipamento == null || equipamento.isBlank()) {
        throw new IllegalArgumentException("Equipamento é obrigatório");
    }

        if(problema == null || problema.isBlank()){
            throw new IllegalArgumentException("A Descricao do problema e obrigatoria");
        }
        
        Manutencao manutencao = new Manutencao();
        manutencao.setNomeEquipamento(equipamento);
        manutencao.setDescricaoProblema(problema);
        manutencao.setDataReporte(LocalDate.now());
        manutencao.setCusto(0.0);
        // status será definido no Service

        return manutencaoService.save(manutencao);
    }
   
    /**
     * Marca uma manutenção como resolvida.
     * @param id
     * @return 
     */
    @Override
    public Manutencao marcarComoResolvido(Long id) {
        return manutencaoService.finalizarManutencao(id);
    }
    
    
}