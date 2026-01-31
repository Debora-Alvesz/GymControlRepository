/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.perfilusuario.entity;
import br.com.ifba.usuario.entity.Usuario;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
/**
 *
 * @author ketli
 * 
 * 
 */
@Data//Anotação do Lombok para getters, setters, toString, etc.
@NoArgsConstructor//Construtor sem argumentos
@AllArgsConstructor//Construtor com todos os argumentos
@Entity // Marca a classe como uma Entidade JPA
@Table(name = "perfil_usuario")//Especifica o nome da tabela no banco de dados
public class PerfilUsuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    private Long id;
    
    @Column(nullable = false, length = 100)
    private String nome;
    
    @Column(nullable = false, length = 500)
    private String descricao;
    

}
