
package br.com.ifba.plano.controller;

import br.com.ifba.plano.entity.Plano;
import br.com.ifba.plano.service.PlanoIService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 *
 * @author Débora Alves
 */
@Controller
@RequiredArgsConstructor
public class PlanoController implements PlanoIController {

    @Autowired
    private final PlanoIService planoService;
    
    @Override
    public Plano save(Plano plano) {
        return planoService.save(plano);
    }

    @Override
    public List<Plano> findAll() {
        return planoService.findAll();
    }

    @Override
    public Plano update(Plano plano) {
        return planoService.update(plano.getId(), plano);
    }

    @Override
    public void delete(Plano plano) {
        planoService.delete(plano.getId());
    }

    @Override
    public Plano findByNome(String nome) {
        return planoService.findByNome(nome);
    }

}
