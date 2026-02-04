
package br.com.ifba.recepcionista.controller;

import br.com.ifba.recepcionista.entity.Recepcionista;
import br.com.ifba.recepcionista.service.RecepcionistaIService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 *
 * @author Débora Alves
 */
@Controller
public class RecepcionistaController implements RecepcionistaIController {

    
    //Instância da camada Service
    @Autowired
    private RecepcionistaIService recepcionistaService;
    
    //Método para salvar recepcionista
    @Override
    public Recepcionista save(Recepcionista recepcionista){   
    return recepcionistaService.save(recepcionista);
    }
    
    //Método para listar recepcionistas
    @Override
    public List<Recepcionista> findAll(){        
    return recepcionistaService.findAll();
    }

    //Método para deletar recepcionista
    @Override
    public void delete(Recepcionista recepcionista){
    // O service espera o ID, então extraímos do objeto
    recepcionistaService.delete(recepcionista.getId());
    }

    // Método específico para atualização
    @Override
    public Recepcionista update( Recepcionista recepcionista){   
    return recepcionistaService.update(recepcionista);
    }
    
    // Método para buscar por nome
    @Override
    public List<Recepcionista> findByName(String nome){
    return recepcionistaService.findByNome(nome);
    }
    
    // Método para buscar por ID
    @Override
    public Recepcionista findById(Long id){
    // O Service retorna Optional, o orElse(null) trata caso não encontre
    return recepcionistaService.findById(id).orElse(null);
    }

}
