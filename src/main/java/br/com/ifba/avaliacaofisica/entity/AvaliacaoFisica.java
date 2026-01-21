/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.avaliacaofisica.entity;

import br.com.ifba.aluno.entity.Aluno;
import br.com.ifba.instrutor.entity.Instrutor;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author João Victor
 */
//Gera metodos getters e setters
@Getter
@Setter
//Gera construtores com todos argumentos e sem nenhum argumento
@NoArgsConstructor
@AllArgsConstructor
//Torna a classe "persistível" no BD
@Entity
//Altera o nome da tabela
@Table(name = "avaliacoes_fisicas")
public class AvaliacaoFisica {
    @Id
    @Column(name = "id", nullable = false, unique = true, length = 20)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "aluno_id", nullable = false)
    private Aluno aluno;
    
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "instrutor_id", nullable = false)
    private Instrutor instrutor;
    
    @Column(name = "data_avaliação", nullable = false)
    private LocalDate dataAvaliacao;
    
    @Column(name = "peso", nullable = false)
    private float peso;
    
    @Column(name = "altura", nullable = false)
    private int altura;
    
    @Column(name = "percentual_gordura", nullable = false)
    private float percentualGordura;
    
    @Column(name = "biceps", nullable = false)
    private int biceps;
    
    @Column(name = "cintura", nullable = false)
    private int cintura;
    
    @Column(name = "ombro", nullable = false)
    private int ombro;
    
    @Column(name = "panturrilha", nullable = false)
    private int panturrilha;
    
    @Column(name = "coxa", nullable = false)
    private int coxa;
    
    @Column(name = "gluteo", nullable = false)
    private int gluteo;
    
    @Column(name = "peitoral", nullable = false)
    private int peitoral;
}
