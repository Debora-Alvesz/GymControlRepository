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
    
    // Define a chave primária da tabela
    @Id
    // Gera o valor do ID automaticamente (auto incremento)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Mapeia o atributo para a coluna id_manutencao
    @Column(name = "id_manutencao", nullable = false, unique = true)
    private Long id;
    
    // Coluna que armazena o nome do equipamento
    @Column(name = "nome_equipamento", nullable = false)
    private String nomeEquipamento;
    
    // Coluna que descreve o problema apresentado
    @Column(name = "descricao_problema", nullable = false)
    private String descricaoProblema;
    
    // Coluna que guarda a data em que o problema foi reportado
    @Column(name = "data_reporte", nullable = false)
    private LocalDate dataReporte;
    
    // Coluna que armazena o custo da manutenção
    @Column(name = "custo", nullable = false)
    private Double custo;
    
    // Coluna que representa o status da manutenção
    @Column(name = "status", nullable = false)
    private String status;
}
