/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.pagamento.controller;

import br.com.ifba.dto.DadosFinanceiro;
import br.com.ifba.pagamento.service.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author ETM-00168
 */
@Controller
public class PagamentoController implements PagamentoIController{

    @Autowired
    private PagamentoService pagamentoService;

    @GetMapping("/dados/{cpf}")
    @Override
    public ResponseEntity<DadosFinanceiro> buscarDadosFinanceiros(String cpf) {
        DadosFinanceiro dados = pagamentoService.buscarDadosFinanceiros(cpf);

        if (dados == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(dados);
    }

    /**
     * Registra o pagamento do aluno
     * @param cpf
     * @return 
     */
    @PostMapping("/registrar/{cpf}")
    @Override
    public ResponseEntity<String> registrarPagamento(String cpf) {
        boolean sucesso = pagamentoService.registrarPagamento(cpf);

        if (sucesso) {
            return ResponseEntity.ok("Pagamento registrado com sucesso!");
        } else {
            return ResponseEntity.badRequest()
                    .body("Erro ao registrar o pagamento.");
        }
    

    }
    
}
