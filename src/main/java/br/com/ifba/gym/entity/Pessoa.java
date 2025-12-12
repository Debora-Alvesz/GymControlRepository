/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.gym.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.FetchType;
import lombok.EqualsAndHashCode;

/**
 *
 * @author ETM-00168
 */
@EqualsAndHashCode(onlyExplicitlyIncluded = true)//ignora todos os campos, exceto os marcados
@Getter //gera automaticamente os métodos get
@Setter //gera automaticamente os métodos set
@Entity // Diz ao JPA que esta classe é uma tabela no banco de dados
@AllArgsConstructor // Gera um construtor que recebe todos os atributos
@NoArgsConstructor // Gera um construtor vazio
@Table(name = "Pessoa") // Define o nome da tabela como "Pessoa"
public class Pessoa{
    
    @EqualsAndHashCode.Include
    // Nome da pessoa, obrigatório (não pode ser nulo no banco)
    @Column(name = "Nome", nullable = false)
    private String nome;
    
    // CPF da pessoa, obrigatório e deve ser único no banco de dados
    @Column(name = "CPF", nullable = false, unique = true)
    @Id // diz que o atibuto é o primary key da tabela
    private String cpf;
    
    // Telefone da pessoa, obrigatório
    @Column(name = "Telefone", nullable = false)
    private int telefone;
    
    // Data de nascimento da pessoa, nao necessariamente obrigatorio
    @Column(name = "Nascimento")
    private Date nascimento;
    
    // Email da pessoa, nao necessariamente obrigatorio
    @Column(name = "Email")
    private String email;
    
    // Relação 1:1 com Endereco (salva/atualiza junto com Pessoa)
    @OneToOne(cascade = CascadeType.ALL)
    // Cria a chave estrangeira "endereco_id" na tabela Pessoa
    @JoinColumn(name = "endereco_id", nullable = false)
    private Endereco endereco;
    
    //Relação 1:1 com Usuario
    @OneToOne(mappedBy = "pessoa",  //'pessoa' é o nome do atributo na classe Usuario
            cascade = CascadeType.ALL, //Persistir o Usuario ao persistir a Pessoa
            fetch = FetchType.LAZY)//melhora o desemprenho e a memória
    private Usuario dadosLogin;
    
}
