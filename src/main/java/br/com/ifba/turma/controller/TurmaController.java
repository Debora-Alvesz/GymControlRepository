package br.com.ifba.turma.controller;

import br.com.ifba.aluno.entity.Aluno;
import br.com.ifba.avaliacaofisica.entity.AvaliacaoFisica;
import br.com.ifba.turma.entity.Turma;
import br.com.ifba.turma.service.TurmaService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class TurmaController implements ITurmaController{

    @Autowired
    private final TurmaService turmaService;

    @Override
    public Turma save(Turma turma) {
        return turmaService.save(turma);
    }

    @Override
    public Turma update(String id, Turma turma) {
        return turmaService.update(id, turma);
    }

    @Override
    public void delete(String id) {
        turmaService.delete(Long.valueOf(id));
    }

    @Override
    public Turma findById(String id) {

        return turmaService.findById(Long.valueOf(id));
    }

    @Override
    public List<Turma> findAll(){
        return turmaService.findAll();
    }
}
