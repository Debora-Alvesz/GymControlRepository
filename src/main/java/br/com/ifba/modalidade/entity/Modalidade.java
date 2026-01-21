/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.modalidade.entity;

import br.com.ifba.turma.entity.Turma;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 *
 * @author ketli
 */
//Não utiliza o Setter pois não deve Settar o ID
@Getter
@NoArgsConstructor//Define construtor sem argumentos(necessário para o Spring)
@AllArgsConstructor//Define construtor com argumentos

@EqualsAndHashCode//define Equals e HashCode
@Entity
@Table(name = "tb_modalidade")//nomeia a tabela
public class Modalidade {
    
    @Id//Define que haverá Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//Gera o id único
    private Long id;
    private String nome;
    private String descricao;
    private String nivelDificuldade;
    private String requisitos;
    
    @OneToMany(mappedBy = "modalidade")//associação um para muitos
    List<Turma> turmas = new ArrayList<>();//define uma lista de turmas que terá a modalidade
  

    public Long getId() {
        return id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
   
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }


    public void setNivelDificuldade(String nivelDificuldade) {
        this.nivelDificuldade = nivelDificuldade;
    }


    public void setRequisitos(String requisitos) {
        this.requisitos = requisitos;
    }

    public List<Turma> getTurmas(){//retorna a lista de Turmas associadas
        return turmas;
        
    }
    
    
}
