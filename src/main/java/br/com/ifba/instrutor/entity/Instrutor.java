
package br.com.ifba.instrutor.entity;

import br.com.ifba.pessoa.entity.Pessoa;
import br.com.ifba.pessoa.entity.Pessoa;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

@Getter//gera automaticamente os métodos get
@Setter//gera automaticamente os métodos set
@NoArgsConstructor//gera um construtor sem argumentos
@AllArgsConstructor//gera um construtor com todos os argumentos
@EqualsAndHashCode(callSuper = true)//inclui os campos de pessoa
@Entity
@Table(name = "instrutor")
@PrimaryKeyJoinColumn(name = "pessoa_id")//define que a chave primaria de Instrutor é a fk que Pessoa
public class Instrutor extends Pessoa{
    
    @Column(name = "cip", nullable = false, unique = true, length = 100)
    private String cip;//define o cip do instrutor como unico
    
    @Column(name = "especialidade", nullable =  false, length = 100)
    private String especialidade;
    
    @Column(name = "carga_horaria")
    private int carga_horaria;
    
    @Column(name = "disponibilidade", nullable = false, length = 100)
    private String disponibilidade;
    
    @Column(name = "status")
    private boolean status;
       
}
