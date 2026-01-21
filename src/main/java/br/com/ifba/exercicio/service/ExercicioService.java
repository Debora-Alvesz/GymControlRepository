
package br.com.ifba.exercicio.service;

import br.com.ifba.exercicio.entity.Exercicio;
import br.com.ifba.exercicio.repository.ExercicioRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Débora Alves
 */

@Service // Diz ao Spring que esta classe contém a lógica de negócio

public class ExercicioService implements ExercicioIService {

    @Autowired // Injeta automaticamente a instância do repositório aqui
    private ExercicioRepository exercicioRepository;

    @Override
    public Exercicio save(Exercicio exercicio) {
        // Verifica se já existe algum exercício com esse nome exato
        if (exercicioRepository.existsByNome(exercicio.getNome())) {
            throw new RuntimeException("Erro: Já existe um exercício com este nome.");
        }
        // Chama o repositório para persistir o novo exercício
        return exercicioRepository.save(exercicio);
    }

    @Override
    public Exercicio update(Exercicio exercicioAtualizado) {
        // Valida se o ID existe para ter certeza que é uma edição e não um novo cadastro
        if (exercicioAtualizado.getId() == null || !exercicioRepository.existsById(exercicioAtualizado.getId())) {
             throw new RuntimeException("Erro: Exercício não encontrado para edição.");
        }
        // Salva os dados atualizados no banco
        return exercicioRepository.save(exercicioAtualizado);
    }

    @Override
    public void delete(Long id) {
        // Verifica se o registro existe antes de tentar deletar para evitar erros
        if (!exercicioRepository.existsById(id)) {
            throw new RuntimeException("Erro: Tentativa de apagar um exercício que não existe.");
        }
        // Comando para apagar o registro do banco de dados
        exercicioRepository.deleteById(id);
    }

    @Override
    public List<Exercicio> findAll() {
        // Retorna a lista de todos os exercícios sem critérios de filtro
        return exercicioRepository.findAll();
    }
    
    @Override
    public Optional<Exercicio> findById(Long id) {
        // Faz a busca por ID e retorna um container que pode conter o exercício
        return exercicioRepository.findById(id);
    }
}