package br.com.ifba.turma.controller;

import br.com.ifba.turma.entity.Turma;
import br.com.ifba.turma.service.TurmaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Controller responsável por expor os endpoints REST e relacionados à entidade Turma.
@RestController // Indica que esta classe é um controller REST
@RequestMapping("/api/turmas") // URL base da API
@RequiredArgsConstructor // Injeção de dependência via construtor
@Slf4j // Habilita o Logger
public class TurmaController implements ITurmaController {

    //Serviço responsável pelas regras de negócio
    private final TurmaService turmaService;

    //Endpoint para criação de uma nova Turma
    @PostMapping
    @Override
    public ResponseEntity<Turma> salvar(@RequestBody Turma turma) {

        log.info("Requisição recebida para salvar nova turma");
        Turma novaTurma = turmaService.salvar(turma);
        log.info("Turma criada com sucesso. ID: {}", novaTurma.getId());
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(novaTurma);
    }

    //Endpoint para listar todas as Turmas
    @GetMapping
    @Override
    public ResponseEntity<List<Turma>> listarTodas() {

        log.info("Requisição para listar todas as turmas");
        return ResponseEntity.ok(turmaService.listarTodas());
    }

    //Endpoint para buscar uma Turma pelo ID
    @GetMapping("/{id}")
    @Override
    public ResponseEntity<Turma> buscarPorId(@PathVariable Long id) {

        log.info("Requisição para buscar turma com ID: {}", id);
        return ResponseEntity.ok(turmaService.buscarPorId(id));
    }

    //Endpoint para atualizar uma Turma existente
    @PutMapping("/{id}")
    @Override
    public ResponseEntity<Turma> atualizar(
            @PathVariable Long id,
            @RequestBody Turma turma) {

        log.info("Requisição para atualizar turma ID: {}", id);

        //Busca a turma existente
        Turma turmaExistente = turmaService.buscarPorId(id);

        //Atualiza os dados permitidos
        turmaExistente.setHorario(turma.getHorario());
        turmaExistente.setCapacidade(turma.getCapacidade());
        turmaExistente.setInstrutor(turma.getInstrutor());
        turmaExistente.setModalidade(turma.getModalidade());

        Turma turmaAtualizada = turmaService.salvar(turmaExistente);
        log.info("Turma atualizada com sucesso. ID: {}", turmaAtualizada.getId());
        return ResponseEntity.ok(turmaAtualizada);
    }

    //Endpoint para excluir uma Turma pelo ID
    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<Void> excluir(@PathVariable Long id) {

        log.warn("Requisição para excluir turma ID: {}", id);
        turmaService.deletar(id);
        log.info("Turma excluída com sucesso. ID: {}", id);
        return ResponseEntity.noContent().build();
    }
}
