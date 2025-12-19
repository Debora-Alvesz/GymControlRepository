/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.plano.service;

import br.com.ifba.exception.BusinessException;
import br.com.ifba.exception.ResourceNotFoundException;
import br.com.ifba.plano.entity.Plano;
import br.com.ifba.plano.repository.PlanoRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 *
 * @author João Victor
 */
 //Marca a classe como um bean de service no Spring
@Service
 //Gera o construtor para os campos "final"
@RequiredArgsConstructor
public class PlanoService implements PlanoIService{

    private static final Logger logger = LoggerFactory.getLogger(PlanoService.class);
    private final PlanoRepository planoRepository;

    @Override
    public Plano save(Plano plano) {
       //Verifica se já existe esse ID no banco
        logger.info("Iniciando cadastro de plano. ID: {}", plano.getId());
        if (planoRepository.existsById(plano.getId())) {
            logger.warn("Tentativa de cadastro de plano com ID já existente: {}", plano.getId());
            throw new BusinessException("Já existe um plano com o ID " + plano.getId());
        }
        //Se passou pelas regras, chama o repository para salvar de fato
        logger.info("Plano cadastrado com sucesso.");
        return planoRepository.save(plano);
    }

    @Override
    public List<Plano> findAll() {
        //Chama o método padrão do JpaRepository para buscar tudo ("SELECT * FROM...")
        logger.info("Buscando lista de planos");
        return planoRepository.findAll();
    }

    @Override
    public Optional<Plano> findById(Long id) {
        //Busca pelo ID. O retorno é Optional para tratar se o usuário não existir.
        logger.info("Buscando plano pelo ID: {}", id);
        return planoRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        //verifica se existe algum plano com esse ID
        logger.info("Solicitação de exclusão do plano. ID: {}", id);
        if (!planoRepository.existsById(id)) {
            // Se não existir, lança um erro e avisa o Controller
            logger.error("Tentativa de exclusão de plano inexistente. ID: {}", id);
            throw new ResourceNotFoundException("O plano com o ID " + id + " não existe na base de dados, por isso não pode ser deletado.");
        }
        // Se passou pelo if, significa que existe. Então pode deletar.
        planoRepository.deleteById(id);
        logger.info("Plano excluído com sucesso. ID: {}", id);
    }
    @Override
    public Plano update(Long id, Plano plano) {
        //Verifica se o plano que queremos editar realmente existe
        logger.info("Iniciando atualização do plano. ID: {}", id);
        if (!planoRepository.existsById(id)) {
            logger.error("Plano não encontrado para atualização. ID: {}", id);
            throw new ResourceNotFoundException("Plano não encontrado para atualização.");
        }
        //Garante que o objeto que vai pro banco tem o ID correto
        plano.setId(id);
        //Salva (o método save serve para atualizar quando o objeto tem ID)
        logger.info("Plano atualizado com sucesso.");
        return planoRepository.save(plano);
    }
}
