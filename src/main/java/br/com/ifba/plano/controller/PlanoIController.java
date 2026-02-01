
package br.com.ifba.plano.controller;

import br.com.ifba.plano.entity.Plano;
import java.util.List;

/**
 *
 * @author Débora Alves
 */
public interface PlanoIController {

    // Salva um novo plano
    Plano save(Plano plano);
    
    // Busca todos os planos para preencher a tabela
    List<Plano> findAll();
    
    // Atualiza um plano existente
    Plano update(Plano plano);
    
    // Deleta um plano (recebendo o objeto completo para segurança)
    void delete(Plano plano);
    
    // Busca por nome
    Plano findByNome(String nome);

}
