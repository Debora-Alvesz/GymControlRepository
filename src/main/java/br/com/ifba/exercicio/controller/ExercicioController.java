/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package br.com.ifba.exercicio.controller;

import br.com.ifba.exercicio.entity.Exercicio;
import br.com.ifba.exercicio.service.ExercicioIService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 *
 * @author Débora Alves
 */
@Controller
public class ExercicioController implements ExercicioIController{

    // Utilizando @Autowired para injetar o Service
    @Autowired
    private ExercicioIService exercicioService;

    @Override
    public List<Exercicio> findAll() {
        // Busca a lista completa no Service para alimentar a tabela na View
        return exercicioService.findAll();
    }

    @Override
    public Exercicio save(Exercicio exercicio) {
        // Encaminha o objeto para o Service salvar
        return exercicioService.save(exercicio);
    }

    @Override
    public Exercicio update(Exercicio exercicio) {
        
        return exercicioService.update(exercicio);
    }

    @Override
    public void delete(Long id) {
        // Solicita a exclusão ao Service
        exercicioService.delete(id);
    }

    @Override
    public Exercicio findById(Long id) {
        // Busca um exercício específico pelo ID técnico
        return exercicioService.findById(id).orElse(null);
    }

}
