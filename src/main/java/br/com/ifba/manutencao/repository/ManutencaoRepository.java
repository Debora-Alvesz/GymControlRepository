/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.ifba.manutencao.repository;

import br.com.ifba.manutencao.entity.Manutencao;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 *
 * @author ricley
 */
@Repository
public interface ManutencaoRepository extends JpaRepository<Manutencao, Long>{

    // Buscar manutenção por ID
    @Override
    Optional<Manutencao> findById(Long id);

    // Deletar manutenção por ID
    @Override
    void deleteById(Long id);

    // Verificar se existe manutenção pelo ID
    @Override
    boolean existsById(Long id);

    // Buscar manutenções por status (ABERTA, CONCLUIDA, etc)
    List<Manutencao> findByStatus(String status);

    // Buscar manutenções pelo nome do equipamento
    List<Manutencao> findByNomeEquipamentoContainingIgnoreCase(String nomeEquipamento);
}
