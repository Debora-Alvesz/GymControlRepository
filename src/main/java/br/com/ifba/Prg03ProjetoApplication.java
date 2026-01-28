package br.com.ifba;

import br.com.ifba.aluno.service.AlunoService;
import br.com.ifba.aluno.view.TelaListagemAlunos;
import br.com.ifba.manutencao.view.TelaManutencao;
import java.awt.EventQueue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Prg03ProjetoApplication {
public static void main(String[] args) {
        // Configura o Spring para NÃO rodar em modo headless
        ConfigurableApplicationContext context = new SpringApplicationBuilder(Prg03ProjetoApplication.class)
                .headless(false)
                .run(args);

        // Inicia a sua tela principal de forma segura para o Swing
        EventQueue.invokeLater(() -> {
            // Busque o bean da sua View principal pelo contexto do Spring
            var principal = context.getBean(br.com.ifba.aluno.view.TelaMatriculaAlunos.class);
            principal.setVisible(true);
            
        });
        
    }
}
