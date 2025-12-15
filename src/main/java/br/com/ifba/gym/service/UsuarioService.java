package br.com.ifba.gym.service;

import br.com.ifba.gym.entity.Usuario;
import br.com.ifba.gym.repository.UsuarioRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 *
 * @author Débora Alves
 */
@Service //Marca a classe como um bean de serviço no Spring
@RequiredArgsConstructor //o lombok gera o construtor para os campos "final"
public class UsuarioService implements UsuarioIService {

    private final UsuarioRepository usuarioRepository;

    @Override
    public Usuario save(Usuario usuario) {
        
       // Verifica se já existe esse CPF no banco (navegando pela Pessoa)
        if (usuarioRepository.existsByPessoaCpf(usuario.getPessoa().getCpf())) {
            throw new RuntimeException("Erro: Já existe um usuário com o CPF " + usuario.getPessoa().getCpf());
        }
        
        // Verifica se já existe esse email no banco (navegando pela Pessoa)
        if (usuarioRepository.existsByPessoaEmail(usuario.getPessoa().getEmail())) {
            throw new RuntimeException("Erro: Já existe um usuário com o E-mail " + usuario.getPessoa().getEmail());
        }

        // Se passou pelas regras, chama o repository para salvar de fato
        return usuarioRepository.save(usuario);
    }

    @Override
    public List<Usuario> findAll() {
        // Chama o método padrão do JpaRepository para buscar tudo ("SELECT * FROM...")
        return usuarioRepository.findAll();
    }

    @Override
    public Optional<Usuario> findById(Long id) {
        // Busca pelo ID. O retorno é Optional para tratar elegantemente se o usuário não existir.
        return usuarioRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        //verifica se existe alguem com esse ID
        if (!usuarioRepository.existsById(id)) {
            // Se não existir, lança um erro e avisa o Controller
            throw new RuntimeException("Erro: O usuário com o ID " + id + " não existe na base de dados, por isso não pode ser deletado.");
        }
        // Se passou pelo if, significa que existe. Então pode deletar.
        usuarioRepository.deleteById(id);
    }
    @Override
    public Usuario update(Long id, Usuario usuario) {
        
        // 1. Verifica se o usuário que queremos editar realmente existe
        if (!usuarioRepository.existsById(id)) {
            throw new RuntimeException("Erro: Usuário não encontrado para atualização.");
        }

        // 2. Verifica se o email já existe em OUTRO registro (navegando pela Pessoa)
        // Correção: usuario.getPessoa().getEmail() e existsByPessoaEmailAndIdNot
        if (usuarioRepository.existsByPessoaEmailAndIdNot(usuario.getPessoa().getEmail(), id)) {
            throw new RuntimeException("Erro: O e-mail " + usuario.getPessoa().getEmail() + " já está sendo usado por outro usuário.");
        }

        // 3. Regra do CPF para Atualização
        // Correção: usuario.getPessoa().getCpf() e existsByPessoaCpfAndIdNot
        if (usuarioRepository.existsByPessoaCpfAndIdNot(usuario.getPessoa().getCpf(), id)) {
            throw new RuntimeException("Erro: O CPF " + usuario.getPessoa().getCpf() + " já pertence a outro usuário.");
        }

        // 4. Garante que o objeto que vai pro banco tem o ID correto
        usuario.setId(id);

        // 5. Salva (o método save serve para atualizar quando o objeto tem ID)
        return usuarioRepository.save(usuario);
    }
}
