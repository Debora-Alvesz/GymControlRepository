/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.ifba.manutencao.repository;

import br.com.ifba.manutencao.entity.Manutencao;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 *
 * @author ricle
 */
public interface ManutencaoRepository extends JpaRepository<Manutencao, Long>{
    
}
