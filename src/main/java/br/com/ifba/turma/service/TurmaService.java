package br.com.ifba.turma.service;

import br.com.ifba.exception.ResourceNotFoundException;
import br.com.ifba.turma.entity.Turma;
import br.com.ifba.turma.repository.TurmaRepository;
import ch.qos.logback.classic.Logger;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class TurmaService implements ITurmaService{

    Logger logger;
    private final TurmaRepository turmaRepository;

    @Override
    public Turma save(Turma turma) {
        validarTurma(turma);
        return turmaRepository.save(turma);
    }

    @Override
    public List<Turma> findAll() {
        return turmaRepository.findAll();
    }

    @Override
    public Turma findById(Long id) {
        return turmaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Turma não encontrada"));
    }

    @Override
    public Turma update(String id, Turma turma) {
        logger.info("Iniciando atualização da turma. id: {}", id);

        // 1. Busca a avaliação existente pela matrícula
        Turma turmaExistente = turmaRepository
                .findById(Long.valueOf(id))
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Turma não encontrada para esse id: " + id
                ));

        // 2. Garante que o ID da avaliação não seja perdido
        turma.setId(turmaExistente.getId());

        // 3. Salva a atualização
        Turma atualizada = turmaRepository.save(turma);
        logger.info("Turma atualizada com sucesso. turma id: {}", id);
        return atualizada;
    }

    @Override
    public void delete(Long id) {
        if (!turmaRepository.existsById(id)) {
            throw new RuntimeException("Turma não encontrada");
        }
        turmaRepository.deleteById(id);
    }

    private void validarTurma(Turma turma) {
        if (turma.getCapacidade() <= 0) {
            throw new IllegalArgumentException("A capacidade deve ser maior que zero.");
        }

        if (turma.getHorario() == null) {
            throw new IllegalArgumentException("O horário da turma é obrigatório.");
        }

        if (turma.getInstrutor() == null) {
            throw new IllegalArgumentException("A turma deve possuir um instrutor.");
        }

        if (turma.getModalidade() == null) {
            throw new IllegalArgumentException("A turma deve possuir uma modalidade.");
        }
    }
}
