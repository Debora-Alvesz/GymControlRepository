

package br.com.ifba.exercicio.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Débora Alves
 */
@Entity // Diz ao Spring/JPA que isso é uma tabela do banco
@Table(name = "exercicios") // Define o nome exato da tabela no banco
@Data // O Lombok gera Getters, Setters, toString e Equals automaticamente
@AllArgsConstructor // Cria um construtor com todos os argumentos
@NoArgsConstructor  // Cria um construtor vazio (Obrigatório para o JPA funcionar)

public class Exercicio {

    @Id // Diz que este campo é a Chave Primária (PK)
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Diz que o Banco vai gerar o número (Auto Increment)
    @Column(name = "id")
    private Long id;

    // unique = true: Impede que existam dois exercícios com o mesmo nome no banco.
     // nullable = false: Torna o campo obrigatório.
     
    @Column(name = "nome", nullable = false, unique = true)
    private String nome;

    // Qual parte do corpo ele treina (Ex: Peito, Costas, Pernas)
    @Column(name = "grupo_muscular", nullable = false)
    private String grupoMuscular;

    // Explicação de como fazer o exercício
    @Column(name = "descricao")
    private String descricao;

    // O que precisa para fazer (Ex: Halteres, Barra, Máquina, Caneleira)
    @Column(name = "tipo_equipamento")
    private String tipoEquipamento;

}