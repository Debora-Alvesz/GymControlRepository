package br.com.ifba.turma.entity;

import br.com.ifba.instrutor.entity.Instrutor;
import br.com.ifba.modalidade.entity.Modalidade;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalTime;

@Entity
@Table (name = "turmas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Turma {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private LocalTime horario;

    @Column(nullable = false)
    private int capacidade;

    @ManyToOne
    @JoinColumn(name = "instrutor_id", nullable = false)
    private Instrutor instrutor;

    @ManyToOne
    @JoinColumn(name = "modalidade_id", nullable = false)
    private Modalidade modalidade;
}
