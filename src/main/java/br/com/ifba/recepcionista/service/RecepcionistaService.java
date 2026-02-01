/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package br.com.ifba.recepcionista.service;

import br.com.ifba.exception.BusinessException;
import br.com.ifba.exception.ResourceNotFoundException;
import br.com.ifba.recepcionista.entity.Recepcionista;
import br.com.ifba.recepcionista.repository.RecepcionistaRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 *
 * @author Débora Alves
 */
@Service
@RequiredArgsConstructor
public class RecepcionistaService implements RecepcionistaIService {

    private static final Logger logger = LoggerFactory.getLogger(RecepcionistaService.class);
    private final RecepcionistaRepository recepcionistaRepository;

    @Override
    public Recepcionista save(Recepcionista recepcionista) {
       //Verifica se já existe esse ID no banco (caso venha preenchido)
        logger.info("[SERVICE] RecepcionistaService - Iniciando cadastro de recepcionista. ID: {}", recepcionista.getId());
        
        if (recepcionista.getId() != null && recepcionistaRepository.existsById(recepcionista.getId())) {
            logger.warn("[SERVICE] RecepcionistaService - Tentativa de cadastro com ID já existente: {}", recepcionista.getId());
            throw new BusinessException("Já existe uma recepcionista com o ID " + recepcionista.getId());
        }
        
        //Se passou pelas regras, chama o repository para salvar de fato
        logger.info("[SERVICE] RecepcionistaService - Recepcionista cadastrada com sucesso.");
        return recepcionistaRepository.save(recepcionista);
    }

    @Override
    public Recepcionista update(Recepcionista recepcionistaTela) {
      // 1. Pega o ID para saber quem estamos editando
        Long id = recepcionistaTela.getId();
        
        logger.info("[SERVICE] RecepcionistaService - Iniciando atualização. ID: {}", id);

        // 2. Busca o cadastro ORIGINAL completo no banco (com senha, endereço, etc.)
        Recepcionista recepcionistaDoBanco = recepcionistaRepository.findById(id)
                .orElseThrow(() -> {
                    logger.error("[SERVICE] Registro não encontrado. ID: {}", id);
                    return new ResourceNotFoundException("Recepcionista não encontrada para atualização.");
                });

        // 3. Atualiza SOMENTE os dados que vieram da tela
        // Assim a Senha e o Endereço originais são preservados!
        recepcionistaDoBanco.setNome(recepcionistaTela.getNome());
        recepcionistaDoBanco.setCpf(recepcionistaTela.getCpf());
        recepcionistaDoBanco.setEmail(recepcionistaTela.getEmail());
        recepcionistaDoBanco.setTelefone(recepcionistaTela.getTelefone());

        // 4. Salva o objeto do banco (que agora tem os dados novos + os dados antigos preservados)
        logger.info("[SERVICE] RecepcionistaService - Recepcionista atualizada com sucesso.");
        return recepcionistaRepository.save(recepcionistaDoBanco);
    }

    @Override
    public void delete(Long id) {
        //Verifica se existe alguma recepcionista com esse ID
        logger.info("[SERVICE] RecepcionistaService - Solicitação de exclusão. ID: {}", id);
        
        if (!recepcionistaRepository.existsById(id)) {
            // Se não existir, lança um erro
            logger.error("[SERVICE] RecepcionistaService - Tentativa de exclusão de registro inexistente. ID: {}", id);
            throw new ResourceNotFoundException("A recepcionista com o ID " + id + " não existe na base de dados.");
        }
        
        // Se passou pelo if, significa que existe. Então pode deletar.
        recepcionistaRepository.deleteById(id);
        logger.info("[SERVICE] RecepcionistaService - Recepcionista excluída com sucesso. ID: {}", id);
    }

    @Override
    public List<Recepcionista> findAll() {
        //Chama o método padrão do JpaRepository para buscar tudo
        logger.info("[SERVICE] RecepcionistaService - Buscando lista de recepcionistas");
        return recepcionistaRepository.findAll();
    }

    @Override
    public Optional<Recepcionista> findById(Long id) {
        //Busca pelo ID. O retorno é Optional para tratar se o usuário não existir.
        logger.info("[SERVICE] RecepcionistaService - Buscando recepcionista pelo ID: {}", id);
        return recepcionistaRepository.findById(id);
    } 

        @Override
        public List<Recepcionista> findByNome(String nome) {
        //Busca específica por nome
        logger.info("[SERVICE] RecepcionistaService - Buscando recepcionista pelo nome: {}", nome);
        return recepcionistaRepository.findByNomeContainingIgnoreCase(nome);
        }
    }

