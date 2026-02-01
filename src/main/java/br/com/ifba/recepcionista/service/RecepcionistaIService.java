
package br.com.ifba.recepcionista.service;

import br.com.ifba.recepcionista.entity.Recepcionista;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Débora Alves
 */
public interface RecepcionistaIService {

   Recepcionista save(Recepcionista recepcionista);
    
    Recepcionista update(Long id, Recepcionista recepcionista);
    
    void delete(Long id);
    
    List<Recepcionista> findAll(); 
    
    Optional<Recepcionista> findById(Long id);
    
    List<Recepcionista> findByName(String nome);
}
