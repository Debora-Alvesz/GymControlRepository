
package br.com.ifba.aluno.controller;

import br.com.ifba.aluno.entity.Aluno;
import br.com.ifba.aluno.service.AlunoIService;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Débora Alves
 */

@Controller //diz para o spring que isso é um controller

public class AlunoController implements AlunoIController {
    
    @Autowired//O Spring injeta automaticamente a instância de ModalidadeService aqui
    private AlunoIService alunoService;

    @Override
    public List<Aluno> findAll() {
        return alunoService.findAll();
    }

    @Override
    public Aluno save(Aluno aluno) {
        return alunoService.save(aluno);
    }

    @Override
    public Aluno update(String cpf, Aluno aluno) {
        return alunoService.update(cpf, aluno);
    }

    @Override
    public void delete(String cpf) {
        alunoService.delete(cpf);
    }

    @Override
    public Aluno findById(String cpf) {
        // Se não encontrar, retorna null
        return alunoService.findById(cpf).orElse(null);
    }   
 
}