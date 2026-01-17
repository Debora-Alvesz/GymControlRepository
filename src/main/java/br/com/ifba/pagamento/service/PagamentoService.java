/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.pagamento.service;

import br.com.ifba.aluno.entity.Aluno;
import br.com.ifba.pagamento.entity.Pagamento;
import br.com.ifba.pagamento.repository.PagamentoRepository;
import br.com.ifba.plano.entity.Plano;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import org.springframework.stereotype.Service;

/**
 *
 * @author ETM-00168
 */
@Service
public class PagamentoService implements PagamentoIService{

    private PagamentoRepository pagamentoRepository;
    
    /**
     * Realiza a baixa do pagamento do aluno.
     *
     * @param aluno aluno que realizará o pagamento
     */
    
    @Override
    public void realizarBaixa(Aluno aluno) {
         // Obtém o plano do aluno
        Plano plano = aluno.getPlano();

        // Cria um novo pagamento
        Pagamento pagamento = new Pagamento();

        // Associa aluno e plano
        pagamento.setIdAluno(aluno);
        pagamento.setIdPlano(plano);

        // Define o valor pago com base no valor do plano
        pagamento.setValorPago(plano.getValor());

        // Define a data atual como data de pagamento
        pagamento.setDataPagamento(LocalDate.now());

        // Define a data de vencimento, após 30 dias
        Date dataVencimento = Date.from(
            LocalDate.now()
                .plusDays(30)
                .atStartOfDay(ZoneId.systemDefault())
                .toInstant()
        );
        pagamento.setDataVencimento(dataVencimento);

        // Define o status como PAGO
        pagamento.setStatus("PAGO");

        // Salva o pagamento
        pagamentoRepository.save(pagamento);
    }
    }

   
