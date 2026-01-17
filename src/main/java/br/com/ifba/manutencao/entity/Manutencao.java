/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.manutencao.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author ricley
 */
@Entity
//Gera metodos getters e setters
@Getter
@Setter
//Gera construtores com todos argumentos e sem nenhum argumento
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "manutencoes")
public class Manutencao {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_manutencao", nullable = false, unique = true)
    private Long id;
    
    @Column(name = "nome_equipamento", nullable = false, length = 100)
    private String nomeEquipamento;
    
    @Column(name = "descricao_problema", nullable = false, length = 255)
    private String descricaoProblema;
    
    @Column(name = "data_reporte", nullable = false)
    private LocalDate dataReporte;
    
    @Column(name = "custo", nullable = false)
    private Double custo;
    
    @Column(name = "status", nullable = false, length = 20)
    private String status;
}
