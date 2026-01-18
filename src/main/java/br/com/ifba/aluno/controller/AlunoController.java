
package br.com.ifba.aluno.controller;

import br.com.ifba.aluno.entity.Aluno;
import br.com.ifba.aluno.service.AlunoService;
import br.com.ifba.plano.entity.Plano;
import br.com.ifba.plano.service.PlanoService;
import java.util.List;
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

    // Injetamos o Service de Aluno (para salvar o aluno)
    private final AlunoService service;
    
    // Injetamos o Service de Plano (para buscar a lista para o ComboBox)
    private final PlanoService planoService;
    
    
    //Busca os planos para preencher a tela (Requisito da Tarefa)
    public List<Plano> buscarTodosPlanos() {
        // Supondo que seu PlanoService tenha um método listarTodos ou findAll
        return planoService.findAll();
    }
    //realiza a matricula
    public void matricularAluno(String nome, String cpf, String email, String matricula, Plano plano) {
       
        try {
            // Cria o objeto 
            Aluno aluno = new Aluno();
            
            // Dados de Pessoa (Usando setNome em vez de setName, verifique sua entidade)
            aluno.setName(nome); 
            aluno.setCpf(cpf);
            aluno.setEmail(email);
            
            // Dados de Aluno
            aluno.setMatricula(matricula);
            
            // Associação do relacionamento 
            aluno.setPlano(plano);

            // Manda pro Service salvar
            service.save(aluno); // Ajuste se o nome for 'save' ou 'salvar'

            // Feedback de sucesso para o usuário
            JOptionPane.showMessageDialog(null, "Matrícula realizada com sucesso!");

        } catch (Exception e) {
            // Tratamento de exceções
            JOptionPane.showMessageDialog(null, "Falha ao realizar matrícula: " + e.getMessage());
            e.printStackTrace(); 
        }
    }
}
