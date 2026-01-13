/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.aluno.service;

import br.com.ifba.aluno.service.AlunoIService;
import br.com.ifba.exception.BusinessException;
import br.com.ifba.exception.ResourceNotFoundException;
import br.com.ifba.aluno.entity.Aluno;
import br.com.ifba.plano.entity.Plano;
import br.com.ifba.aluno.repository.AlunoRepository;
import br.com.ifba.plano.repository.PlanoRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 *
 * @author ricley
 */
@Service//Marca a classe como um bean de serviço no Spring
@RequiredArgsConstructor//o lombok gera o construtor para os campos "final"
public class AlunoService implements AlunoIService{

    private static final Logger logger = LoggerFactory.getLogger(AlunoService.class);
    private final AlunoRepository alunoRepository;
    private final PlanoRepository planoRepository;

    @Override
    public Aluno matriculaAluno(Aluno novoAluno, Long planoId) {

        
         // 1️⃣ Valida matrícula vazia
        logger.info("Iniciando matrícula do aluno. CPF: {}, Plano ID: {}", novoAluno.getCpf(), planoId);
        if (novoAluno.getMatricula() == null || novoAluno.getMatricula().isEmpty()) {
            logger.warn("Matrícula vazia informada para CPF: {}", novoAluno.getCpf());
            throw new ResourceNotFoundException("Matrícula não pode ser vazia.");
        }

        // 2️⃣ Valida matrícula duplicada
        if (alunoRepository.existsByMatricula(novoAluno.getMatricula())) {
            logger.warn("Tentativa de matrícula duplicada: {}", novoAluno.getMatricula());
            throw new BusinessException("Matrícula já cadastrada.");
        }

        // 3️⃣ Busca plano pelo ID
        logger.error("Plano não encontrado. ID: {}", planoId);
        Plano plano = planoRepository.findById(planoId).orElseThrow(() -> new RuntimeException("Erro: Plano com ID " + planoId + " não encontrado."));

        // 4️⃣ Valida plano ativo
        if (!plano.isStatus()) {
            logger.warn("Tentativa de matrícula em plano inativo. Plano ID: {}", planoId);
            throw new ResourceNotFoundException("Não é possível matricular em um plano inativo.");
        }

        // 5️⃣ Associa plano ao aluno
        novoAluno.setPlano(plano);

        // 6️⃣ Salva no banco
        logger.info("Aluno matriculado com sucesso.");
        return alunoRepository.save(novoAluno);
    }

    @Override
    public List<Aluno> findAll() {
        logger.info("Buscando lista de alunos");
        return alunoRepository.findAll();
    }

    @Override
    public Optional<Aluno> findById(String cpf) {
        logger.info("Buscando aluno pelo CPF: {}", cpf);
        return alunoRepository.findById(cpf);
    }

    @Override
    public Aluno save(Aluno aluno) {
        // Valida matrícula não vazia
        logger.info("Iniciando cadastro de aluno. CPF: {}", aluno.getCpf());
        if (aluno.getMatricula() == null || aluno.getMatricula().isEmpty()) {
            logger.warn("Tentativa de cadastro com matrícula vazia. CPF: {}", aluno.getCpf());
            throw new ResourceNotFoundException("Matrícula não pode ser vazia.");
        }

        // Valida matrícula duplicada
        if (alunoRepository.existsByMatricula(aluno.getMatricula())) {
            logger.warn("Tentativa de cadastro com matrícula vazia. CPF: {}", aluno.getCpf());
            throw new BusinessException("Matrícula já cadastrada.");
        }

        // Valida plano associado
        if (aluno.getPlano() == null) {
            logger.warn("Aluno sem plano associado. CPF: {}", aluno.getCpf());
            throw new ResourceNotFoundException("Aluno deve ter um plano associado.");
        }

        logger.info("Aluno cadastrado com sucesso.");
        return alunoRepository.save(aluno);
    
    }

    @Override
    public Aluno update(String cpf, Aluno aluno) {

        logger.info("Iniciando atualização do aluno. CPF: {}", cpf);
          Aluno existente = alunoRepository.findById(cpf).orElseThrow(() -> new RuntimeException("Erro: Aluno não encontrado."));
        logger.error("Aluno não encontrado para atualização. CPF: {}", cpf);

        if (alunoRepository.existsByMatriculaAndCpfNot(aluno.getMatricula(), existente.getCpf())) {
            logger.warn("Matrícula já usada por outro aluno: {}", aluno.getMatricula());
            throw new BusinessException("Matrícula já usada por outro aluno.");
        }

        existente.setMatricula(aluno.getMatricula());

        if (aluno.getPlano() != null) {
            existente.setPlano(aluno.getPlano());
        }

        logger.info("Aluno atualizado com sucesso.");
            return alunoRepository.save(existente);
        }

    @Override
    public void delete(String cpf) {

        logger.info("Solicitação de exclusão do aluno. CPF: {}", cpf);
        if (!alunoRepository.existsById(cpf)) {
            logger.error("Tentativa de exclusão de aluno inexistente. CPF: {}", cpf);
            throw new ResourceNotFoundException("O aluno com CPF " + cpf + " não existe na base de dados.");
        }
        alunoRepository.deleteById(cpf);
        logger.info("Aluno excluído com sucesso. CPF: {}", cpf);
    }
    
}