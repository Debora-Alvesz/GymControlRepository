/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.ifba.pagamento.service;
        
import br.com.ifba.aluno.entity.Aluno;

/**
 *
 * @author ETM-00168
 */
public interface PagamentoIService {

    /**
     * Realiza a baixa de pagamento de um aluno,
     * considerando o valor do plano associado.
     *
     * @param aluno aluno que terá o pagamento registrado
     */
    void realizarBaixa(Aluno aluno);
    
}
