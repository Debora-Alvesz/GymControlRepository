/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author ETM-00168
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DadosFinanceiro {
    
    private String cpf;
    private String matricula;
    private String nomeAluno;
    private double valor;
    
}
