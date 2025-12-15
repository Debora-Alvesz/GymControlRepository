
package br.com.ifba.gym.repository;

import br.com.ifba.gym.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
/**
 *
 * @author Débora Alves
 */
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
 
    //Busca um registro de Usuario baseado no e-mail da Pessoa associada.
    Optional<Usuario> findByPessoaEmail(String email);

    // Verifica se JÁ EXISTE algum usuário com esse e-mail associado.
    boolean existsByPessoaEmail(String email);

    // Busca um usuário baseado no CPF da pessoa.
    Optional<Usuario> findByPessoaCpf(String cpf);
    
    // Verifica se existe um usuário ligado a uma pessoa com este CPF.
    boolean existsByPessoaCpf(String cpf);

    // Verifica duplicidade de E-mail APENAS em outros usuários.
    boolean existsByPessoaEmailAndIdNot(String email, Long id);
    
    // Verifica se o CPF já está sendo usado por OUTRO usuário diferente do que estou editando.
    boolean existsByPessoaCpfAndIdNot(String cpf, Long id);

    // Busca um usuário pelo login.
    Optional<Usuario> findByLogin(String login);
}