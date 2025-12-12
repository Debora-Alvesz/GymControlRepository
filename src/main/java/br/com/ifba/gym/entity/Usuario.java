/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.gym.entity;

import lombok.EqualsAndHashCode;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import jakarta.persistence.OneToOne;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

/**
 *
 * @author ketli
 */

@Data//Anotação do Lombok para getters, setters, toString, etc.
@NoArgsConstructor //Construtor sem argumentos
@AllArgsConstructor// Gera um construtor que recebe todos os atributos
@Entity
@Table(name = "usuarios")
@EqualsAndHashCode(callSuper = true,onlyExplicitlyIncluded = true)// Indica ao Lombok para chamar a implementação equals/hashCode da superclasse (Pessoa)
public class Usuario extends Pessoa{
    
    @Id //Marca o campo como a Chave Primária (Primary Key)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include // Marca o campo 'id' como o ÚNICO a ser usado para equals e hashCode
    @Column(name= "id_usuario")
    private Long id;
    
     @Column(name = "login", nullable = false, unique = true, length = 50)//Configura detalhes da coluna (não nulo, tamanho máximo)
    private String login;
    
     @Column(name = "senha", nullable = false, length= 100)
    private String senha;
    
     @Column(name = "funcao", nullable = false, length = 100)
    private String funcao;
    
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pessoa_id") // Coluna na tabela 'usuarios' que armazena a chave de 'Pessoa'
    private Pessoa pessoa;
    
    //relação 1:1 com PerfilUsuario
    @OneToOne(mappedBy = "usuario", //'usuario' é o nome do atributo na classe Usuario
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private PerfilUsuario perfil;
  
    
    
}
