
package br.com.ifba.recepcionista.controller;

import br.com.ifba.recepcionista.entity.Recepcionista;
import java.util.List;

/**
 *
 * @author Débora Alves
 */
public interface RecepcionistaIController {

    Recepcionista save(Recepcionista recepcionista);
    
    List<Recepcionista> findAll();
    
    void delete(Recepcionista recepcionista);
    
    // Atualiza passando o ID e o Objeto (conforme definido no Service)
    Recepcionista update(Recepcionista recepcionista);
    
    // Métodos extras solicitados anteriormente (busca por nome e id)
    List<Recepcionista> findByName(String nome);
    
    Recepcionista findById(Long id);
    
}
