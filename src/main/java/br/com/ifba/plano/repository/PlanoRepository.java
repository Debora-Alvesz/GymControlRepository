/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.ifba.plano.repository;

import br.com.ifba.plano.entity.Plano;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author João Victor
 */
public interface PlanoRepository extends JpaRepository<Plano, Long>{
    //Procura o plano pelo nome
    Optional<Plano> findByNome(String nome);
    //Lista todos os nomes da classe Plano
    @Query("SELECT p.nome FROM Plano p")
    List<String> findAllNomes();
    //Procura o plano pela duração
    Optional<Plano> findByDuracao(int duracao);
    List<Plano> findAllByDuracaoGreaterThan(int duracao);
    //Procura por plano com duração entre o valor minimo e o valor maximo inserido
    List<Plano> findAllByDuracaoBetween(int min, int max);
    //Procura por plano pelo valor
    Optional<Plano> findByValor(float valor);
    //Procura por plano com valor abaixo do valor inserido
    List<Plano> findAllByValorLessThan(float valor);
    //Procura por plano entre o valor minimo e o valor maximo inserido
    List<Plano> findAllByValorBetween(float min, float max);
    //Procura o plano com o menor valor
    @Query("SELECT MIN(p.valor) FROM Plano p")
    Float findMenorValor();
    //Procura o plano com o maior valor
    @Query("SELECT MAX(p.valor) FROM Plano p")
    Float findMaiorValor();
    //Ordena os planos pelo valor em ordem crescente
    List<Plano> findAllByOrderByValorAsc();
    //Procura todos planos com o valor da matricula especificado
    List<Plano> findAllByValorMatricula(float valorMatricula);
    //Procura os planos pela data de criação
    List<Plano> findAllByDataCriacao(LocalDate data);
    //Procura os planos criados em um intervalo de tempo
    List<Plano> findAllByDataCriacaoBetween(LocalDate inicio, LocalDate fim);
    //Procura por planos criados a partir de uma data
    List<Plano> findAllByDataCriacaoAfter(LocalDate data);
    //Procura por todos os planos ativos
    List<Plano> findAllByStatusTrue();
    //Procura por todos planos inativos
    List<Plano> findAllByStatusFalse();
}
