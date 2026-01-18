
package br.com.ifba.exercicio.repository;

import br.com.ifba.exercicio.entity.Exercicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Débora Alves
 */

@Repository // Define que esta classe é um componente de acesso a dados do Spring

public interface ExercicioRepository extends JpaRepository<Exercicio, Long> {

    //Método para verificar duplicidade de nome.
    boolean existsByName(String nome);
}
