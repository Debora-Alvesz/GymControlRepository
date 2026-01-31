
package br.com.ifba.instrutor.entity;

import br.com.ifba.pessoa.entity.Pessoa;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "instrutor")
@PrimaryKeyJoinColumn(name = "pessoa_id")//define que a chave primaria de Instrutor é a fk que Pessoa
@DiscriminatorValue("INSTRUTOR")////diz ao hibernate qual valor inserir na coluna discriminadora para identificar qual subclasse o registro representa
public class Instrutor extends Pessoa{
    
    @Column(name = "cip", nullable = false, unique = true, length = 100)
    private String cip;//define o cip do instrutor como unico
    
    @Column(name = "especialidade", nullable =  false, length = 100)
    private String especialidade;
    
    @Column(name = "carga_horaria")
    private int carga_horaria;
    
    @Column(name = "disponibilidade", length = 100)
    private String disponibilidade;
    
    @Column(name = "status")
    private boolean status;
       
}
