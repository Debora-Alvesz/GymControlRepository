/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.pagamento.service;

import br.com.ifba.aluno.entity.Aluno;
import br.com.ifba.aluno.repository.AlunoRepository;
import br.com.ifba.dto.DadosFinanceiro;
import br.com.ifba.pagamento.entity.Pagamento;
import br.com.ifba.pagamento.repository.PagamentoRepository;
import br.com.ifba.plano.entity.Plano;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ETM-00168
 */
@Service
public class PagamentoService implements PagamentoIService{

    @Autowired
    private PagamentoRepository pagamentoRepository;
    
    @Autowired
    private AlunoRepository alunorepository;

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

    @Override
    public boolean registrarPagamento(String cpf) {
         /*
     * Busca o aluno no banco de dados pelo CPF.
     * Caso não encontre, lança exceção.
     */
        Aluno aluno = alunorepository.findByCpf(cpf)
            .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));

         /*
     * Realiza a baixa do pagamento para o aluno.
     * Este método normalmente:
     * - Marca o pagamento como realizado
     * - Atualiza o status financeiro
     * - Registra a data do pagamento
     */
    realizarBaixa(aluno);
     /*
     * Retorna true indicando que o pagamento
     * foi registrado com sucesso.
     */
    return true;
    }

    @Override
    public DadosFinanceiro buscarDadosFinanceiros(String cpf) {
         /*
     * Busca o aluno no banco de dados pelo CPF.
     * O método findByCpf retorna um Optional<Aluno>.
     *
     * Caso o aluno não seja encontrado,
     * é lançada uma RuntimeException.
     */
        Aluno aluno = alunorepository.findByCpf(cpf)
            .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));

    Plano plano = aluno.getPlano();

    /*
     * Cria e retorna um objeto DadosFinanceiro (DTO),
     * contendo apenas as informações necessárias para a camada externa
     * (Controller / API), evitando expor a entidade Aluno diretamente.
     */
    return new DadosFinanceiro(
        aluno.getCpf(),
        aluno.getMatricula(),
        aluno.getName(),              
        aluno.getPlano().getValor()
);

    }
    }

   
