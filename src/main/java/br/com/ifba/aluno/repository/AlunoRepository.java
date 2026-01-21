/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.ifba.aluno.repository;

import br.com.ifba.aluno.entity.Aluno;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author ricle
 */
public interface AlunoRepository extends JpaRepository<Aluno, Long>{


    // Lista alunos por nome
    List<Aluno> findAllByOrderByNomeAsc();

    //Busca aluno pela matricula
    Optional<Aluno> findByMatricula(String matricula);
    
    //Busca aluno pelo CPF
    Optional<Aluno> findByCpf(String cpf);
    
    //Verifica se existe um aluno com essa matricula
    boolean existsByMatricula(String matricula);
    
    boolean existsByCpf(String cpf);
    
    void deleteByCpf(String cpf);

    //Verifica duplicidade de matricula
    boolean existsByMatriculaAndCpfNot(String matricula, String cpf);
    
    //Lista todos os alunos de um determinado plano
    List<Aluno> findByPlanoId(Long planoId);
    
    //Lista alunos por status do plano (ativo/inativo)
    List<Aluno> findByPlanoStatus(boolean status);
    
    //Verifica se existe um aluno vinculado a um plano
    boolean existsByPlanoId(Long plano);
    
    // Lista alunos que estão em planos mais caros que X
    List<Aluno> findByPlanoValorGreaterThan(float valor);

    // Lista alunos que estão em planos mais baratos que X
    List<Aluno> findByPlanoValorLessThanEqual(float valor);
    
    // Lista todos os alunos de um plano ordenados pelo nome
    @Query("SELECT a FROM Aluno a WHERE a.plano.id = :planoId ORDER BY a.name ASC")
    List<Aluno> findByPlanoIdOrderByPessoaNomeAsc(@Param("planoId") Long planoId);
    
}
