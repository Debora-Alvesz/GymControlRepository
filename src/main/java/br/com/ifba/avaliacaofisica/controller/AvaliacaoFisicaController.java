/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.avaliacaofisica.controller;

import br.com.ifba.avaliacaofisica.entity.AvaliacaoFisica;
import br.com.ifba.avaliacaofisica.service.AvaliacaoFisicaIService;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author João Victor
 */
public class AvaliacaoFisicaController implements AvaliacaoFisicaIController{
    
    //Instância da camada Service
    @Autowired
    private AvaliacaoFisicaIService avaliacaoFisicaService;
    
    //Método para salvar Avaliacão Fisica
    @Override
    public AvaliacaoFisica save(AvaliacaoFisica avaliacaoFisica){   
    return avaliacaoFisicaService.save(avaliacaoFisica);
    }
    
    //Método para listar Avaliacões Fisicas
    @Override
    public List<AvaliacaoFisica> findAll(){        
    return avaliacaoFisicaService.findAll();
    }
    
    //Método para buscar Avaliacão Fisica por matricula
    @Override
    public AvaliacaoFisica findByAluno_Matricula(String matricula){
    return avaliacaoFisicaService.findByAluno_Matricula(matricula);
    }
    
    //Método para deletar avaliação do aluno
    @Override
    public void delete(AvaliacaoFisica avaliacaoFisica){
    avaliacaoFisicaService.delete(avaliacaoFisica);
    }
    
    //Método para deletar avaliação pela matricula do aluno
    @Override
    public void deleteByMatricula(String matricula){    
    avaliacaoFisicaService.deleteByMatricula(matricula);
    }
    
    // Método específico para atualização
    @Override
    public AvaliacaoFisica update(String matricula, AvaliacaoFisica avaliacaoFisica){   
    return avaliacaoFisicaService.update(matricula, avaliacaoFisica);
    }
    
    // Método para calcular IMC
    @Override
    public float calcularImc(int altura, float peso){   
    return avaliacaoFisicaService.calcularImc(altura, peso);
    }
    
    // Método para listar as avaliações fisicas que um dia especifico
    @Override
    public List<AvaliacaoFisica> findByDataAvaliacao(LocalDate dataAvaliacao){   
    return avaliacaoFisicaService.findByDataAvaliacao(dataAvaliacao);
    }
}
