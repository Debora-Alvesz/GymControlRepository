/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.usuario.entity;

import br.com.ifba.perfilusuario.entity.PerfilUsuario;
import br.com.ifba.pessoa.entity.Pessoa;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author ketli
 */

@Entity//define a classe como entidade
@Getter//gera os getters
@Setter//gera os setters
@NoArgsConstructor//gera um construtor vazio(importante para o Springboot)
@AllArgsConstructor//gera um construtor com todos os argumentos
@EqualsAndHashCode(onlyExplicitlyIncluded = true)//gera automaticamente Equals e HashCode
@Table(name = "usuario")//Define o nome da tabela
public class Usuario {

    @Id//define um identificador único para cada objeto
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name = "id_usuario")
    private Long id;

    @Column(name = "login", nullable = false, unique = true, length = 50)
    private String login;

    @Column(name = "senha", nullable = false, length = 100)
    private String senha;

    @Column(name = "funcao", nullable = false, length = 100)
    private String funcao;

    // Relação 1:1 com Pessoa (dono da FK)
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pessoa_cpf", nullable = false, unique = true)
    private Pessoa pessoa;
    
    @ManyToOne
    @JoinColumn(name = "perfil_id", nullable = false)
    private PerfilUsuario perfilUsuario;
    
    
}
