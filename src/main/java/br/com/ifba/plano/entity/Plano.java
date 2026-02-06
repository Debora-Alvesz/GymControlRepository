/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.plano.entity;

import br.com.ifba.aluno.entity.Aluno;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import java.time.LocalDate;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author João Victor
 */

//Gera metodos getters e setters
@Getter
@Setter
//Gera construtores com todos argumentos e sem nenhum argumento
@NoArgsConstructor
@AllArgsConstructor
//Cria os metodos Equals e HashCode
@EqualsAndHashCode
//Torna a classe "persistível" no BD
@Entity
//Altera o nome da tabela
@Table(name = "planos")
public class Plano {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;//Define o id do plano como unico
    
    @Column(name = "nome", nullable =  false, length = 100)
    private String nome;

    @Column(name = "duracao", nullable = false)
    private int duracao;
    
    @Column(name = "valor", nullable = false)
    private double valor;
    
    @Column(name = "beneficios", length = 100)
    private String beneficios;

    @Column(name = "valor_matricula", nullable = false)
    private float valorMatricula;
    
    @Column(name = "data_criacao", updatable = false)
    private LocalDate dataCriacao;
    
    @Column(name = "status", nullable = false)
    private boolean status;
    
    //Relacionamento com Aluno
    @OneToMany(mappedBy = "plano")
    private List<Aluno> aluno;
    
}