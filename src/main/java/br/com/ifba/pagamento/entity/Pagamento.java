/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.pagamento.entity;

import br.com.ifba.aluno.entity.Aluno;
import br.com.ifba.plano.entity.Plano;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author ETM-00168
 */

// Gera automaticamente os métodos getters (getId, getValorPago, etc.)
@Getter
// Gera automaticamente os métodos setters (setId, setValorPago, etc.)
@Setter
// Cria um construtor vazio (sem parâmetros)
@NoArgsConstructor
// Cria um construtor com todos os atributos como parâmetros
@AllArgsConstructor
// Indica que esta classe é uma entidade JPA (mapeada para uma tabela do banco)
@Entity
// Define o nome da tabela no banco de dados
@Table(name = "pagamento")
public class Pagamento {

    
    @Id // Define o atributo como chave primária da tabela
    // Mapeia o atributo para a coluna "id", que não pode ser nula nem repetida
    @Column(name = "id", nullable = false, unique = true)
    private long id;
    
    // Mapeia o valor pago do pagamento
    @Column(name = "valorPago", nullable = false)
    private float valorPago;

    // Data em que o pagamento foi realizado
    @Column(name = "data", nullable = false)
    private LocalDate dataPagamento;

    // Data de vencimento do pagamento
    @Column(name = "dataVencimento", nullable = false)
    private Date dataVencimento;

    // Status do pagamento (ex: PAGO, PENDENTE, ATRASADO)
    @Column(name = "status")
    private String status;

    
    // Muitos pagamentos podem pertencer a um aluno
    @ManyToOne // Relacionamento muitos-para-um:
    
    // Define a coluna de chave estrangeira que referencia o aluno
    @JoinColumn(name = "id_aluno", nullable = false)
    private Aluno idAluno;

    
    // Muitos pagamentos podem estar associados a um plano
    @ManyToOne // Relacionamento muitos-para-um:
    
    // Define a coluna de chave estrangeira que referencia o plano
    @JoinColumn(name = "id_plano", nullable = false)
    private Plano idPlano;
}
