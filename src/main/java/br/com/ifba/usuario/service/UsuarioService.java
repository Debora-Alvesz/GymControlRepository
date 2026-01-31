
package br.com.ifba.usuario.service;

import br.com.ifba.exception.BusinessException;
import br.com.ifba.exception.ResourceNotFoundException;
import br.com.ifba.usuario.entity.Usuario;
import br.com.ifba.usuario.repository.UsuarioRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 *
 * @author Débora Alves
 */
@Service //Marca a classe como um bean de serviço no Spring
@RequiredArgsConstructor //o lombok gera o construtor para os campos "final"
public class UsuarioService implements UsuarioIService {

    private static final Logger logger = LoggerFactory.getLogger(UsuarioService.class);
    private final UsuarioRepository usuarioRepository;

    @Override
   public Usuario validarLogin(String login, String senha) {
        logger.info("[SERVICE] UsuarioService - Tentativa de autenticação para o usuário: {}", login);

    
        //Busca o usuário e já valida se existe
        Usuario usuario = usuarioRepository.findByLogin(login)
                .orElseThrow(() -> new BusinessException("Usuário não encontrado"));

        //verifica a senha
        if (!usuario.getSenha().equals(senha)) { 
            logger.warn("[SERVICE] Senha incorreta para o usuário '{}'.", login);
            throw new BusinessException("Senha inválida!");
        }
         logger.info("[SERVICE] UsuarioService - Login efetuado com sucesso para: {}", login);
        return usuario;//retorna o objeto com o perfilUsuario dentro
    }
    
    @Override
    public Usuario save(Usuario usuario) {

        logger.info("[SERVICE] UsuarioService - Iniciando cadastro de usuário com CPF: {}", usuario.getPessoa().getCpf());

       // Verifica se já existe esse CPF no banco (navegando pela Pessoa)
        if (usuarioRepository.existsByPessoaCpf(usuario.getPessoa().getCpf())) {
            logger.warn("[SERVICE] UsuarioService - Tentativa de cadastro com CPF já existente: {}", usuario.getPessoa().getCpf());
            throw new BusinessException("Já existe um usuário com esse CPF");
        }
        
        // Verifica se já existe esse email no banco (navegando pela Pessoa)
        if (usuarioRepository.existsByPessoaEmail(usuario.getPessoa().getEmail())) {
            logger.warn("[SERVICE] UsuarioService - Tentativa de cadastro com e-mail já existente: {}", usuario.getPessoa().getEmail());
            throw new BusinessException("Já existe um usuário com esse email");
        }

        // Se passou pelas regras, chama o repository para salvar de fato
        logger.info("[SERVICE] UsuarioService - Usuário cadastrado com sucesso.");
        return usuarioRepository.save(usuario);
    }

    @Override
    public List<Usuario> findAll() {
        // Chama o método padrão do JpaRepository para buscar tudo ("SELECT * FROM...")
        logger.info("[SERVICE] UsuarioService - Buscando lista de usuários");
        return usuarioRepository.findAll();
    }

    @Override
    public Optional<Usuario> findById(Long id) {
        // Busca pelo ID. O retorno é Optional para tratar elegantemente se o usuário não existir.
        logger.info("[SERVICE] UsuarioService - Buscando usuário pelo ID: {}", id);
        return usuarioRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        //verifica se existe alguem com esse ID
        logger.info("[SERVICE] UsuarioService - Solicitação de exclusão do usuário ID: {}", id);
        if (!usuarioRepository.existsById(id)) {
            // Se não existir, lança um erro e avisa o Controller
            logger.error("[SERVICE] UsuarioService - Falha ao deletar. Usuário não encontrado. ID: {}", id);
            throw new ResourceNotFoundException("Usuário não encontrado.");
        }
        // Se passou pelo if, significa que existe. Então pode deletar.
        usuarioRepository.deleteById(id);
        logger.info("[SERVICE] UsuarioService - Usuário deletado com sucesso. ID: {}", id);
    }
    @Override
    public Usuario update(Long id, Usuario usuario) {

        logger.info("[SERVICE] UsuarioService - Iniciando atualização do usuário ID: {}", id);
        // 1. Verifica se o usuário que queremos editar realmente existe
        if (!usuarioRepository.existsById(id)) {
            logger.error("[SERVICE] UsuarioService - Usuário não encontrado para atualização. ID: {}", id);
            throw new ResourceNotFoundException("Usuário não encontrado.");
        }

        // 2. Verifica se o email já existe em OUTRO registro (navegando pela Pessoa)
        // Correção: usuario.getPessoa().getEmail() e existsByPessoaEmailAndIdNot
        if (usuarioRepository.existsByPessoaEmailAndIdNot(usuario.getPessoa().getEmail(), id)) {
            logger.warn("[SERVICE] UsuarioService - E-mail já utilizado por outro usuário: {}", usuario.getPessoa().getEmail());
            throw new BusinessException("Email já foi cadastrado.");
        }

        // 3. Regra do CPF para Atualização
        // Correção: usuario.getPessoa().getCpf() e existsByPessoaCpfAndIdNot
        if (usuarioRepository.existsByPessoaCpfAndIdNot(usuario.getPessoa().getCpf(), id)) {
            logger.warn("[SERVICE] UsuarioService - CPF já utilizado por outro usuário: {}", usuario.getPessoa().getCpf());
            throw new BusinessException("CPF já cadastrado.");
        }

        // 4. Garante que o objeto que vai pro banco tem o ID correto
        usuario.setId(id);
        logger.info("[SERVICE] UsuarioService - Usuário atualizado com sucesso.");

        // 5. Salva (o método save serve para atualizar quando o objeto tem ID)
        return usuarioRepository.save(usuario);
    }
   
}