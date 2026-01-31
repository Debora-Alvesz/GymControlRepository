/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.ifba.administrador.repository;

import br.com.ifba.administrador.entity.Administrador;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author João Victor
 */
@Repository
public interface AdministradorRepository extends JpaRepository<Administrador, Long>{
    
    
    // Método para verificar se existe um administrador com o cpf informado
    Optional<Administrador> existsByCpf(String cpf);
}
