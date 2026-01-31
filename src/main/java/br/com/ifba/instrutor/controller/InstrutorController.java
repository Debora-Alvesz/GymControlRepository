package br.com.ifba.instrutor.controller;

import br.com.ifba.instrutor.entity.Instrutor;
import br.com.ifba.instrutor.service.InstrutorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/instrutores") // Define a URL base da API
@RequiredArgsConstructor
@Slf4j
public class InstrutorController {


     //Injeção do serviço de Instrutor O Spring injeta automaticamente essa dependência
    private final InstrutorService instrutorService;


     //Endpoint para cadastrar um novo instrutor URL: /api/instrutores
    @PostMapping
    public ResponseEntity<Instrutor> salvar(@RequestBody Instrutor instrutor) {

        // Log informativo indicando início do cadastro
        log.info("Requisição para cadastrar instrutor");

        // Chama o serviço para salvar o instrutor
        // Retorna HTTP 201 (CREATED) com o objeto salvo
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(instrutorService.salvar(instrutor));
    }


     //Endpoint para listar todos os instrutores URL: /api/instrutores
    @GetMapping
    public ResponseEntity<List<Instrutor>> listarTodos() {

        // Log informativo
        log.info("Requisição para listar instrutores");

        // Retorna HTTP 200 (OK) com a lista de instrutores
        return ResponseEntity.ok(instrutorService.listarTodos());
    }


     //Endpoint para buscar um instrutor pelo ID URL: /api/instrutores/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Instrutor> buscarPorId(@PathVariable Long id) {

        // Log informativo com o ID solicitado
        log.info("Requisição para buscar instrutor ID: {}", id);

        // Retorna o instrutor encontrado
        return ResponseEntity.ok(instrutorService.buscarPorId(id));
    }


     //Endpoint para atualizar um instrutor existente URL: /api/instrutores/{id}
    @PutMapping("/{id}")
    public ResponseEntity<Instrutor> atualizar(
            @PathVariable Long id,          // ID do instrutor
            @RequestBody Instrutor instrutor) { // Dados atualizados

        // Log informativo
        log.info("Requisição para atualizar instrutor ID: {}", id);

        // Chama o serviço para atualizar
        return ResponseEntity.ok(instrutorService.atualizar(id, instrutor));
    }


     //Endpoint para remover um instrutor URL: /api/instrutores/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {

        // Log de aviso (operação sensível)
        log.warn("Requisição para deletar instrutor ID: {}", id);

        // Chama o serviço para deletar
        instrutorService.deletar(id);

        // Retorna HTTP 204 (No Content)
        return ResponseEntity.noContent().build();
    }
}
