/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.administrador.entity;

import br.com.ifba.pessoa.entity.Pessoa;
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
public class Administrador extends Pessoa {
    
}
