package br.com.ifba;

import br.com.ifba.view.TelaDeLogin;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Prg03ProjetoApplication {
public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(Prg03ProjetoApplication.class)
                .headless(false) // Necessário para telas Swing/AWT
                .run(args);

        // Pede ao Spring para criar a tela (ele injetará o UsuarioService automaticamente)
        java.awt.EventQueue.invokeLater(() -> {
            TelaDeLogin tela = context.getBean(TelaDeLogin.class);
            
            tela.setVisible(true);
        });      
    }
}
