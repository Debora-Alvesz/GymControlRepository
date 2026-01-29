
package br.com.ifba.exercicio.service;

import br.com.ifba.exercicio.entity.Exercicio;
import br.com.ifba.exercicio.repository.ExercicioRepository;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Débora Alves
 */

@Service // Diz ao Spring que esta classe contém a lógica de negócio

public class ExercicioService implements ExercicioIService {

    private static final Logger logger = LoggerFactory.getLogger(ExercicioService.class);
    
    @Autowired // Injeta automaticamente a instância do repositório aqui
    private ExercicioRepository exercicioRepository;

    @Override
    public Exercicio save(Exercicio exercicio) {
        //logs de informacao de save
        logger.info("[SERVICE] ExercicioService - Iniciando cadastro de exercício. Nome: {}", exercicio.getNome());
        
        // Verifica se já existe algum exercício com esse nome exato
        if (exercicioRepository.existsByNome(exercicio.getNome())) {
            logger.error("[SERVICE] ExercicioService - Tentativa de cadastro de exercício com nome duplicado: {}",
                    exercicio.getNome());
            throw new RuntimeException("Erro: Já existe um exercício com este nome.");
        }
        
        logger.info("[SERVICE] ExercicioService - Exercício cadastrado com sucesso.");
        // Chama o repositório para persistir o novo exercício
        return exercicioRepository.save(exercicio);
    }

    @Override
    public Exercicio update(Exercicio exercicioAtualizado) {
        //logs de informacao de update
        logger.info("[SERVICE] ExercicioService - Iniciando atualização do exercício. ID: {}", exercicioAtualizado.getId());
        
        // Valida se o ID existe para ter certeza que é uma edição e não um novo cadastro
        if (exercicioAtualizado.getId() == null || !exercicioRepository.existsById(exercicioAtualizado.getId())) {
            logger.error("[SERVICE] ExercicioService - Exercício não encontrado para edição. ID: {}",
                    exercicioAtualizado.getId());
             throw new RuntimeException("Erro: Exercício não encontrado para edição.");
        }
        
        logger.info("[SERVICE] ExercicioService - Exercício atualizado com sucesso. ID: {}", exercicioAtualizado.getId());
        // Salva os dados atualizados no banco
        return exercicioRepository.save(exercicioAtualizado);
    }

    @Override
    public void delete(Long id) {
        //log de informacao de delete
        logger.info("[SERVICE] ExercicioService - Solicitação de exclusão do exercício. ID: {}", id);
        
        // Verifica se o registro existe antes de tentar deletar para evitar erros
        if (!exercicioRepository.existsById(id)) {
            logger.error("[SERVICE] ExercicioService - Tentativa de exclusão de exercício inexistente. ID: {}", id);
            throw new RuntimeException("Erro: Tentativa de apagar um exercício que não existe.");
        }
        
        logger.info("[SERVICE] ExercicioService - Exercício excluído com sucesso. ID: {}", id);
        // Comando para apagar o registro do banco de dados
        exercicioRepository.deleteById(id);
    }

    @Override
    public List<Exercicio> findAll() {
        
        logger.info("[SERVICE] ExercicioService - Listando todos os exercícios");
        // Retorna a lista de todos os exercícios sem critérios de filtro
        return exercicioRepository.findAll();
    }
    
    @Override
    public Optional<Exercicio> findById(Long id) {
        
        logger.info("[SERVICE] ExercicioService - Buscando exercício por ID: {}", id);
        // Faz a busca por ID e retorna um container que pode conter o exercício
        return exercicioRepository.findById(id);
    }
}