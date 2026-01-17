/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.manutencao.service;

import br.com.ifba.manutencao.entity.Manutencao;
import br.com.ifba.manutencao.repository.ManutencaoRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 *
 * @author ricley
 */
@Service//Marca a classe como um bean de serviço no Spring
@RequiredArgsConstructor//o lombok gera o construtor para os campos "final"
public class ManutencaoService implements ManutencaoIService{

    public final ManutencaoRepository manutencaoRepository;
    
    @Override
    public Manutencao save(Manutencao manutencao) {
        
        manutencao.setStatus("PENDENTE");
        
        return manutencaoRepository.save(manutencao);    }

    @Override
    public Manutencao finalizarManutencao(Long id) {
        Manutencao manutencao = manutencaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Manutenção não encontrada."));

        manutencao.setStatus("RESOLVIDO");
        
        return manutencaoRepository.save(manutencao);

    }

    @Override
    public List<Manutencao> findAll() {
        return manutencaoRepository.findAll();
    }
    
    
}
