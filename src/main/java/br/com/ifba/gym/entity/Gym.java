/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.gym.entity;

import br.com.ifba.insfrastructure.entity.PesistenceEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author ETM-00168
 */
@Getter
@Setter
@Entity
@Table(name = "GymControl")
public class Gym extends PesistenceEntity{
    
    @Column(name = "Nome", nullable = false)
    private String nome;
    
    @Column(name = "Codigo", nullable = false, unique = true)
    private String codigo;
    
    @Column(name = "Telefone", nullable = false)
    private String telefone;
    
    @Column(name = "HoarioFuncionamento", nullable = false)
    private String horarioFuncionamento;
    
    @Column(name = "Status")
    private boolean status;
    
   
    
}
