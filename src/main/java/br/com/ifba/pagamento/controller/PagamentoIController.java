/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.ifba.pagamento.controller;

import br.com.ifba.dto.DadosFinanceiro;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author ETM-00168
 */
public interface PagamentoIController {
    
    ResponseEntity<DadosFinanceiro> buscarDadosFinanceiros(
            @PathVariable String cpf);
    
    ResponseEntity<String> registrarPagamento(
            @PathVariable String cpf);
    
    
}
