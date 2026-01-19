
package br.com.ifba.exercicio.service;

import br.com.ifba.exercicio.entity.Exercicio;
import br.com.ifba.exercicio.repository.ExercicioRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 *
 * @author Débora Alves
 */

@Service // Diz ao Spring que esta classe contém a lógica de negócio
@RequiredArgsConstructor

public class ExercicioService {

    // Injeção de dependência do Repository (para podermos consultar o banco)
    private final ExercicioRepository exercicioRepository;

    // Salva ou Atualiza um exercício.
@Transactional
    public Exercicio save(Exercicio exercicio) {
        // Verifica se já existe algum exercício com esse nome exato
        if (exercicioRepository.existsByNome(exercicio.getNome())) {
            throw new RuntimeException("Erro: Já existe um exercício com este nome.");
        }
        return exercicioRepository.save(exercicio);
    }

    // edita exercicio
    @Transactional
    public Exercicio update(Exercicio exercicioAtualizado) {
        // Verifica se o exercício existe no banco pelo ID
        if (exercicioAtualizado.getId() == null || !exercicioRepository.existsById(exercicioAtualizado.getId())) {
             throw new RuntimeException("Erro: Exercício não encontrado para edição.");
        }
        
        return exercicioRepository.save(exercicioAtualizado);
    }

    // deleta exercicio
    @Transactional
    public void delete(Long id) {
        if (!exercicioRepository.existsById(id)) {
            throw new RuntimeException("Erro: Tentativa de apagar um exercício que não existe.");
        }
        exercicioRepository.deleteById(id);
    }

    //lista todos exercicios
    public List<Exercicio> findAll() {
        return exercicioRepository.findAll();
    }
    
    //Busca por ID
    public Exercicio findById(Long id) {
        return exercicioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Exercício não encontrado."));
    }
}

