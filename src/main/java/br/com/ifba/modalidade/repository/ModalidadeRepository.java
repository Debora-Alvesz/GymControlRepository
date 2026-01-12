/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.ifba.modalidade.repository;
import br.com.ifba.modalidade.entity.Modalidade;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ketli
 */
@Repository
public interface ModalidadeRepository extends JpaRepository<Modalidade, Long>{
     
}
