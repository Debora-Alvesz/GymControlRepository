/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.ifba.pagamento.repository;

import br.com.ifba.aluno.entity.Aluno;
import br.com.ifba.pagamento.entity.Pagamento;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ETM-00168
 */
@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {
    
    /**
     * Busca todos os pagamentos pelo status.
     * Exemplo: "PAGO", "PENDENTE", "CANCELADO"
     */
    List<Pagamento> findByStatus(String status);

    
   /**
     * Busca pagamentos com valor maior que o valor informado.
     */
    List<Pagamento> findByValorGreaterThan(float valor);
    
    //busca pagamento por data informada
    List<Pagamento> findByDataPagamento(LocalDate dataPagamento);
    
     /**
     * Busca pagamentos por aluno.
     */
    List<Pagamento> findByIdAluno(Aluno aluno);
    
    /**
     * Verifica se já existe pagamento para o aluno em determinada data.
     */
    boolean existsByIdAlunoAndStatus(Aluno aluno, String status);
}
