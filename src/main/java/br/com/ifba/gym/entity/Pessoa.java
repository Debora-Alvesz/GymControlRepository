/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.gym.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.FetchType;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import java.time.LocalDate;
import lombok.EqualsAndHashCode;

/**
 *
 * @author ETM-00168
 */
@Entity
@Table(name = "pessoa")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(
    name = "tipo_pessoa",
    discriminatorType = DiscriminatorType.STRING
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Pessoa {

    @Id
    @EqualsAndHashCode.Include
    @Column(name = "cpf", nullable = false, unique = true, length = 11)
    private String cpf;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "telefone", nullable = false)
    private String telefone;

    @Column(name = "nascimento")
    private LocalDate nascimento;

    @Column(name = "email")
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id", nullable = false)
    private Endereco endereco;

    @OneToOne(mappedBy = "pessoa", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Usuario dadosLogin;
}
