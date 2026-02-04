package br.com.ifba.view; // Ajuste para o seu pacote de infra ou view

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class ContextProvider implements ApplicationContextAware {

    // O segredo está no 'static': isso permite que o contexto seja acessado sem 'new'
    private static ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        // O Spring chama este método automaticamente ao iniciar
        context = applicationContext;
    }

    // Método estático para buscar qualquer Controller ou Service no sistema
    public static <T> T getBean(Class<T> beanClass) {
        return context.getBean(beanClass);
    }
}