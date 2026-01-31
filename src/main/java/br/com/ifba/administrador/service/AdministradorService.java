/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.administrador.service;

import br.com.ifba.administrador.entity.Administrador;
import br.com.ifba.administrador.repository.AdministradorRepository;
import br.com.ifba.avaliacaofisica.service.AvaliacaoFisicaService;
import br.com.ifba.exception.ResourceNotFoundException;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author João Victor
 */
@Service
public class AdministradorService implements AdministradorIService{
    private static final Logger logger = LoggerFactory.getLogger(AvaliacaoFisicaService.class);
    @Autowired
    private AdministradorRepository administradorRepository;
    
    @Override
    public Administrador save(Administrador administrador) {

    logger.info("Iniciando cadastro");

    Administrador salvo = administradorRepository.save(administrador);
    logger.info("Administrador cadastrado com sucesso.");
    return salvo;
    }

    @Override
    public List<Administrador> findAll() {
        //Chama o método padrão do JpaRepository para buscar tudo ("SELECT * FROM...")
        logger.info("Buscando lista de administradores");
        return administradorRepository.findAll();
    }

    @Override
    public void delete(Administrador administrador) {
        logger.info("Solicitação de exclusão de administrador. CPF do administrador: {}", administrador.getCpf());

    // 1. Verifica se existe avaliação física para a matrícula informada
    administradorRepository
            .existsByCpf(administrador.getCpf())
            .orElseThrow(() -> new ResourceNotFoundException(
                    "Não existe administrador cadastrado com esse CPF: " + administrador.getCpf()
            ));

    // 2. Remove a avaliação
    administradorRepository.delete(administrador);
    logger.info("Administrador excluído com sucesso. CPF do administrador: {}", administrador.getCpf());
    }
    
    @Override
    public Administrador update(String cpf, Administrador administrador) {
        logger.info("Iniciando atualização do administrador. CPF do administrador: {}", administrador.getCpf());

    // 1. Busca a avaliação existente pela matrícula
    Administrador administradorExistente = administradorRepository
            .existsByCpf(cpf)
            .orElseThrow(() -> new ResourceNotFoundException(
                    "Administrador não encontrado com o CPF: " + cpf
            ));

    // 2. Garante que o ID da avaliação não seja perdido
    administrador.setId(administradorExistente.getId());

    // 4. Salva a atualização
    Administrador atualizado = administradorRepository.save(administrador);
    logger.info("Administrador atualizado com sucesso. CPF do administrador: {}", cpf);
    return atualizado;
    }
}
