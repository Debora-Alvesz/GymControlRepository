
package br.com.ifba.aluno.controller;

import br.com.ifba.aluno.entity.Aluno;
import br.com.ifba.aluno.service.AlunoService;
import br.com.ifba.plano.entity.Plano;
import javax.swing.JOptionPane;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

/**
 *
 * @author Débora Alves
 */

@Controller //diz para o spring que isso é um controller
@RequiredArgsConstructor // o lombok cria o construtor nos campos com "final"
public class AlunoController {

    private final AlunoService service;
    
    public void matricularAluno(String nome, String cpf, String email, String matricula, Plano plano) {
       
        try {
            //Cria o objeto 
            Aluno aluno = new Aluno();
            
            // Dados de Aluno
            aluno.setName(nome);
            aluno.setCpf(cpf);
            aluno.setEmail(email);
            aluno.setMatricula(matricula);
            // Associação do relacionamento 
            aluno.setPlano(plano);

            // Manda pro Service salvar
            service.save(aluno);

            // Feedback de sucesso para o usuário
            JOptionPane.showMessageDialog(null, "Matrícula realizada!");

        } catch (Exception e) {
            //Tratamento de exceções técnicas (ex: Erro de conexão, Constraints do Banco)
            JOptionPane.showMessageDialog(null, "Falha ao realizar matrícula: " + e.getMessage());
            e.printStackTrace(); // Log do erro no console para depuração
        }
    }
}
