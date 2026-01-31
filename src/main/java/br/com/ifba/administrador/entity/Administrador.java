/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.administrador.entity;

import br.com.ifba.pessoa.entity.Pessoa;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
/**
 *
 * @author ketli
 */

@Entity
@Table(name = "administrador")
@PrimaryKeyJoinColumn(name = "pessoa_id")//define que pk desta tabela também é FK da tabela Pessoa
@DiscriminatorValue("ADM")////diz ao hibernate qual valor inserir na coluna discriminadora para identificar qual subclasse o registro representa
public class Administrador extends Pessoa {
    
    
}
