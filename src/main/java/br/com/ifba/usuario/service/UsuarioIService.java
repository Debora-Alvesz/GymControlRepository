
package br.com.ifba.usuario.service;

import br.com.ifba.gym.entity.Usuario;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Débora Alves
 */
public interface UsuarioIService {
    //método para salvar usuários
    Usuario save(Usuario usuario);
    
    //MÉtodo para listar usuarios
    List<Usuario> findAll();
    
    //Método para buscar usuarios por id
    Optional<Usuario> findById(Long id);
    
    //método para deletar usuario pelo id
    void delete(Long id);
    
    // Método específico para atualização
    Usuario update(Long id, Usuario usuario);
}