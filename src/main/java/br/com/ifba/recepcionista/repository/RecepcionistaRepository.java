package br.com.ifba.recepcionista.repository;

import br.com.ifba.recepcionista.entity.Recepcionista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 * @author Débora Alves
 */
@Repository
public interface RecepcionistaRepository extends JpaRepository<Recepcionista, Long> {

    // Método para buscar recepcionistas pelo nome.
    // O 'ContainingIgnoreCase' permite buscar por partes do nome e ignora maiúsculas/minúsculas.
    List<Recepcionista> findByNameContainingIgnoreCase(String nome);
    
}