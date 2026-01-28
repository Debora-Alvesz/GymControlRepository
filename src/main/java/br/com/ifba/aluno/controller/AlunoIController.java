
package br.com.ifba.aluno.controller;

import br.com.ifba.aluno.entity.Aluno;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Débora Alves
 */
public interface AlunoIController {

    // Listar todos
    List<Aluno> findAll();

    // Matricular (Salvar)
    Aluno save(Aluno aluno);

   // Atualiza um aluno existente (busca pelo ID do banco)
    Aluno update(String cpf, Aluno aluno);

    // Deleta pelo ID cpf
    void delete(String cpf);

    // Busca pelo ID do banco
    Aluno findById(String cpf);
    
    //Verifica se existe um aluno com essa matricula
    boolean existsByMatricula(String matricula);
    
    //Busca a data de vencimento do aluno
    public Date getDataVencimento(Aluno aluno);
}
