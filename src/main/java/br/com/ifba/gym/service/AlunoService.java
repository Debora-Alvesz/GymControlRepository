/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.gym.service;

import br.com.ifba.gym.entity.Aluno;
import br.com.ifba.gym.entity.Plano;
import br.com.ifba.gym.repository.AlunoRepository;
import br.com.ifba.gym.repository.PlanoRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 *
 * @author ricle
 */
@Service//Marca a classe como um bean de serviço no Spring
@RequiredArgsConstructor//o lombok gera o construtor para os campos "final"
public class AlunoService implements AlunoIService{
    
    private final AlunoRepository alunoRepository;
    private final PlanoRepository planoRepository;

    @Override
    public Aluno matriculaAluno(Aluno novoAluno, Long planoId) {
        
         // 1️⃣ Valida matrícula vazia
    if (novoAluno.getMatricula() == null || novoAluno.getMatricula().isEmpty()) {
        throw new RuntimeException("Erro: Matrícula não pode ser vazia.");
    }

    // 2️⃣ Valida matrícula duplicada
    if (alunoRepository.existsByMatricula(novoAluno.getMatricula())) {
        throw new RuntimeException("Erro: Matrícula já cadastrada.");
    }

    // 3️⃣ Busca plano pelo ID
    Plano plano = planoRepository.findById(planoId)
            .orElseThrow(() -> new RuntimeException(
                    "Erro: Plano com ID " + planoId + " não encontrado."));

    // 4️⃣ Valida plano ativo
    if (!plano.isStatus()) {
        throw new RuntimeException("Erro: Não é possível matricular em um plano inativo.");
    }

    // 5️⃣ Associa plano ao aluno
    novoAluno.setPlano(plano);

    // 6️⃣ Salva no banco
    return alunoRepository.save(novoAluno);
    }

    @Override
    public List<Aluno> findAll() {
        return alunoRepository.findAll();
    }

    @Override
    public Optional<Aluno> findById(String cpf) {
        return alunoRepository.findById(cpf);
    }

    @Override
    public Aluno save(Aluno aluno) {
        // Valida matrícula não vazia
        if (aluno.getMatricula() == null || aluno.getMatricula().isEmpty()) {
            throw new RuntimeException("Erro: Matrícula não pode ser vazia.");
        }

        // Valida matrícula duplicada
        if (alunoRepository.existsByMatricula(aluno.getMatricula())) {
            throw new RuntimeException("Erro: Matrícula já cadastrada.");
        }

        // Valida plano associado
        if (aluno.getPlano() == null) {
            throw new RuntimeException("Erro: Aluno deve ter um plano associado.");
        }

        return alunoRepository.save(aluno);
    
    }

    @Override
    public Aluno update(String cpf, Aluno aluno) {
          Aluno existente = alunoRepository.findById(cpf)
            .orElseThrow(() -> new RuntimeException("Erro: Aluno não encontrado."));

        if (alunoRepository.existsByMatriculaAndCpfNot(aluno.getMatricula(), existente.getCpf())) {
        throw new RuntimeException("Erro: Matrícula já usada por outro aluno.");
    }

        existente.setMatricula(aluno.getMatricula());

        if (aluno.getPlano() != null) {
        existente.setPlano(aluno.getPlano());
    }

        return alunoRepository.save(existente);
    }

    @Override
    public void delete(String cpf) {
        if (!alunoRepository.existsById(cpf)) {
            throw new RuntimeException(
                    "Erro: O aluno com CPF " + cpf + " não existe na base de dados.");
        }
        alunoRepository.deleteById(cpf);
    }
    
}