package br.com.ifba.turma.service;

import br.com.ifba.turma.entity.Turma;
import br.com.ifba.turma.repository.TurmaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


//Classe de serviço responsável pelas regras de negócio e relacionadas à entidade Turma.

@Service 
@RequiredArgsConstructor 
@Slf4j //Habilita o Logger
public class TurmaService implements ITurmaService {

    //Repositório responsável pelo acesso ao banco de dados
    private final TurmaRepository turmaRepository;

    //Salva uma nova Turma no banco de dados
    @Override
    public Turma salvar(Turma turma) {
        log.info("Iniciando salvamento da turma");
        
        //Valida as regras de negócio antes de salvar
        validarTurma(turma);
        Turma turmaSalva = turmaRepository.save(turma);
        log.info("Turma salva com sucesso. ID: {}", turmaSalva.getId());
        return turmaSalva;
    }

    //Lista todas as turmas cadastradas
    @Override
    public List<Turma> listarTodas() {
        log.info("Listando todas as turmas cadastradas");
        return turmaRepository.findAll();
    }

    //Busca uma turma pelo ID
    @Override
    public Turma buscarPorId(Long id) {
        log.info("Buscando turma pelo ID: {}", id);

        return turmaRepository.findById(id)
                .orElseThrow(() -> {
                    log.error("Turma não encontrada para o ID: {}", id);
                    return new RuntimeException("Turma não encontrada");
                });
    }

    
    //Remove uma turma pelo ID
    @Override
    public void deletar(Long id) {
        log.info("Solicitação para deletar turma ID: {}", id);

        // Verifica se a turma existe antes de excluir
        if (!turmaRepository.existsById(id)) {
            log.warn("Tentativa de exclusão de turma inexistente. ID: {}", id);
            throw new RuntimeException("Turma não encontrada");
        }

        turmaRepository.deleteById(id);
        log.info("Turma deletada com sucesso. ID: {}", id);
    }

    
     //Método responsável por validar as regras de negócio da Turma

    private void validarTurma(Turma turma) {

        log.debug("Validando dados da turma");

        if (turma.getCapacidade() <= 0) {
            log.error("Capacidade inválida: {}", turma.getCapacidade());
            throw new IllegalArgumentException("A capacidade deve ser maior que zero.");
        }

        if (turma.getHorario() == null) {
            log.error("Horário da turma não informado");
            throw new IllegalArgumentException("O horário da turma é obrigatório.");
        }

        if (turma.getInstrutor() == null) {
            log.error("Instrutor não informado");
            throw new IllegalArgumentException("A turma deve possuir um instrutor.");
        }

        if (turma.getModalidade() == null) {
            log.error("Modalidade não informada");
            throw new IllegalArgumentException("A turma deve possuir uma modalidade.");
        }

        log.debug("Validação da turma realizada com sucesso");
    }
}
