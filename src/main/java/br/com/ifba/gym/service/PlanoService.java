/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.gym.service;

import br.com.ifba.gym.entity.Plano;
import br.com.ifba.gym.repository.PlanoRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 *
 * @author João Victor
 */
 //Marca a classe como um bean de service no Spring
@Service
 //Gera o construtor para os campos "final"
@RequiredArgsConstructor
public class PlanoService implements PlanoIService{
    private final PlanoRepository planoRepository;

    @Override
    public Plano save(Plano plano) {
       //Verifica se já existe esse ID no banco
        if (planoRepository.existsById(plano.getPlano().getId())) {
            throw new RuntimeException("Erro: Já existe um plano com o ID " + plano.getPlano().getId());
        }
        //Se passou pelas regras, chama o repository para salvar de fato
        return planoRepository.save(plano);
    }

    @Override
    public List<Plano> findAll() {
        //Chama o método padrão do JpaRepository para buscar tudo ("SELECT * FROM...")
        return planoRepository.findAll();
    }

    @Override
    public Optional<Plano> findById(Long id) {
        //Busca pelo ID. O retorno é Optional para tratar se o usuário não existir.
        return planoRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        //verifica se existe algum plano com esse ID
        if (!planoRepository.existsById(id)) {
            // Se não existir, lança um erro e avisa o Controller
            throw new RuntimeException("Erro: O plano com o ID " + id + " não existe na base de dados, por isso não pode ser deletado.");
        }
        // Se passou pelo if, significa que existe. Então pode deletar.
        planoRepository.deleteById(id);
    }
    @Override
    public Plano update(Long id, Plano plano) {
        //Verifica se o plano que queremos editar realmente existe
        if (!planoRepository.existsById(id)) {
            throw new RuntimeException("Erro: Plano não encontrado para atualização.");
        }
        //Garante que o objeto que vai pro banco tem o ID correto
        plano.setId(id);
        //Salva (o método save serve para atualizar quando o objeto tem ID)
        return planoRepository.save(plano);
    }
}
