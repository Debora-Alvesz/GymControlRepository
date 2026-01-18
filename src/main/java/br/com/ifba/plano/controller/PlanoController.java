
package br.com.ifba.plano.controller;

import br.com.ifba.plano.entity.Plano;
import br.com.ifba.plano.service.PlanoService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

/**
 *
 * @author Débora Alves
 */

@Controller
@RequiredArgsConstructor
public class PlanoController {

    private final PlanoService planoService;
    
    public List<Plano> findAll() {
        return planoService.findAll();
    }
}
