/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.gym.entity;

import br.com.ifba.infrastructure.entity.PesistenceEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author ETM-00168
 */
@Getter //gera automaticamente os métodos get
@Setter //gera automaticamente os métodos set
@AllArgsConstructor // Gera um construtor que recebe todos os atributos
@NoArgsConstructor // Gera um construtor vazio
@Entity // será mapeada como uma tabela no banco de dados
@Table(name = "Endereco") // Define o nome da tabela como "Endereco"
public class Endereco extends PesistenceEntity{
    
    // Campo "cidade".
    @Column(name = "Cidade", nullable = false)
    private String cidade;
    
    // Campo "bairro".
    @Column(name = "Bairro", nullable = false) 
    private String bairro;
    
    // Campo "rua".
    @Column(name = "Rua", nullable = false)
    private String rua;
    
    // Campo "numero".
    @Column(name = "Numero", nullable = false)
    private int numero;
    
    // Campo "cep".
    @Column(name = "Cep", nullable = false)
    private String cep;
    
    // Campo "complemento".
    @Column(name = "Complemento", nullable = false)
    private String complemento;
    
}
