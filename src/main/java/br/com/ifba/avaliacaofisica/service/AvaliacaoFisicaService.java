/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.avaliacaofisica.service;

import br.com.ifba.aluno.entity.Aluno;
import br.com.ifba.aluno.repository.AlunoRepository;
import br.com.ifba.avaliacaofisica.entity.AvaliacaoFisica;
import br.com.ifba.avaliacaofisica.repository.AvaliacaoFisicaRepository;
import br.com.ifba.exception.BusinessException;
import br.com.ifba.exception.ResourceNotFoundException;
import br.com.ifba.plano.service.PlanoService;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author João Victor
 */
//Marca a classe como um bean de service no Spring
@Service
 //Gera o construtor para os campos "final"
@RequiredArgsConstructor
public class AvaliacaoFisicaService implements AvaliacaoFisicaIService {
    
    private static final Logger logger = LoggerFactory.getLogger(AvaliacaoFisicaService.class);
    @Autowired
    private AvaliacaoFisicaRepository avaliacaoFisicaRepository;
    @Autowired
    private AlunoRepository alunoRepository;
    
    @Override
    public AvaliacaoFisica save(AvaliacaoFisica avaliacaoFisica) {
       String matricula = avaliacaoFisica.getAluno().getMatricula();

    logger.info("Iniciando cadastro de avaliação física. Matrícula do aluno: {}", matricula);

    // 1. Verifica se o aluno existe
    Aluno aluno = alunoRepository.findByMatricula(matricula)
            .orElseThrow(() -> new ResourceNotFoundException(
                    "Aluno não encontrado com a matrícula: " + matricula
            ));

    // 2. Verifica se o aluno já possui avaliação física
    if (avaliacaoFisicaRepository.existsByAlunoMatricula(matricula)) {
        logger.warn("Tentativa de cadastro duplicado de avaliação para matrícula: {}", matricula);
        throw new BusinessException(
                "O aluno de matrícula " + matricula + " já possui uma avaliação física cadastrada."
        );
    }

    // 3. Associa o aluno gerenciado pelo JPA à avaliação
    avaliacaoFisica.setAluno(aluno);

    // 4. Salva a avaliação
    AvaliacaoFisica salva = avaliacaoFisicaRepository.save(avaliacaoFisica);
    logger.info("Avaliação física cadastrada com sucesso. ID: {}", salva.getId());
    return salva;
    }

    @Override
    public List<AvaliacaoFisica> findAll() {
        //Chama o método padrão do JpaRepository para buscar tudo ("SELECT * FROM...")
        logger.info("Buscando lista de avaliações");
        return avaliacaoFisicaRepository.findAll();
    }

    @Override
    public Optional<AvaliacaoFisica> findAlunoByMatricula(String matricula) {
        //Busca pelo CPF do aluno. O retorno é Optional para tratar se o usuário não existir.
        logger.info("Buscando avaliação pela matricula do aluno: {}", matricula);
        return avaliacaoFisicaRepository.findAlunoByMatricula(matricula);
    }

    @Override
    public void delete(String matricula) {
        logger.info("Solicitação de exclusão da avaliação física. Matrícula do aluno: {}", matricula);

    // 1. Verifica se existe avaliação física para a matrícula informada
    AvaliacaoFisica avaliacao = avaliacaoFisicaRepository
            .findByAlunoMatricula(matricula)
            .orElseThrow(() -> new ResourceNotFoundException(
                    "Não existe avaliação física cadastrada para o aluno de matrícula: " + matricula
            ));

    // 2. Remove a avaliação
    avaliacaoFisicaRepository.delete(avaliacao);
    logger.info("Avaliação física excluída com sucesso. Matrícula do aluno: {}", matricula);
    }
    
    @Override
    public AvaliacaoFisica update(String matricula, AvaliacaoFisica avaliacaoFisica) {
        logger.info("Iniciando atualização da avaliação física. Matrícula do aluno: {}", matricula);

    // 1. Busca a avaliação existente pela matrícula
    AvaliacaoFisica avaliacaoExistente = avaliacaoFisicaRepository
            .findByAlunoMatricula(matricula)
            .orElseThrow(() -> new ResourceNotFoundException(
                    "Avaliação física não encontrada para o aluno de matrícula: " + matricula
            ));

    // 2. Garante que o ID da avaliação não seja perdido
    avaliacaoFisica.setId(avaliacaoExistente.getId());

    // 3. Mantém o mesmo aluno (não permite trocar aluno na atualização)
    avaliacaoFisica.setAluno(avaliacaoExistente.getAluno());

    // 4. Salva a atualização
    AvaliacaoFisica atualizada = avaliacaoFisicaRepository.save(avaliacaoFisica);
    logger.info("Avaliação física atualizada com sucesso. Matrícula do aluno: {}", matricula);
    return atualizada;
    }
    
    @Override
    public float calcularImc(int altura, float peso) {
        // Verifica se a altura ou o peso não são valores negativos ou nulos
        if (altura <= 0 || peso <= 0) {
            throw new IllegalArgumentException("Altura e peso devem ser maiores que zero");
        }
        // Transforma a altura que está em cm para metros
        float alturaMetros = altura / 100.0f;
        //Retorna o IMC
        return peso / (alturaMetros * alturaMetros);
    }
    
    @Override
    public List<AvaliacaoFisica> findByDataAvaliacao(LocalDate dataAvaliacao) {

    logger.info("Buscando avaliações físicas da data: {}", dataAvaliacao);

    // Procura por todas as avaliações da data especifica
    List<AvaliacaoFisica> avaliacoes =
            avaliacaoFisicaRepository.findByDataAvaliacao(dataAvaliacao);

    // Caso não encontre nenhuma avaliação, mostra a mensagem
    if (avaliacoes.isEmpty()) {
        logger.warn("Nenhuma avaliação física encontrada para a data: {}", dataAvaliacao);
        throw new ResourceNotFoundException(
                "Nenhuma avaliação física encontrada para a data: " + dataAvaliacao
        );
    }

    return avaliacoes;
}
}
