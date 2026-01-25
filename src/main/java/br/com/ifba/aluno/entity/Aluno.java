/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.aluno.entity;

import br.com.ifba.pessoa.entity.Pessoa;
import br.com.ifba.plano.entity.Plano;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
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
@EqualsAndHashCode(callSuper = true)
//Torna a classe "persistível" no BD
@Entity
//Altera o nome da tabela
@Table(name = "alunos")
//Define que a chave primaria de Aluno é a pk de Pessoa
@PrimaryKeyJoinColumn(name = "pessoa_id")
public class Aluno extends Pessoa{
  
    @Column(name = "matricula", nullable =  false, length = 20, unique = true)
    private String matricula;

    @Column(name = "requisitos", nullable = false, length = 100)
    private String requisitos; 
    
    //Relacionamento com Plano
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "plano_id", nullable = false)
    private Plano plano;
}
