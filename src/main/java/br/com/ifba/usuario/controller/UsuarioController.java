/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.usuario.controller;

import br.com.ifba.perfilusuario.entity.PerfilUsuario;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import br.com.ifba.usuario.entity.Usuario;
import br.com.ifba.usuario.enums.PerfilUsuarioEnums;
import br.com.ifba.usuario.service.UsuarioService;


/**
 *
 * @author ketli
 */
@Controller
@RequiredArgsConstructor
public class UsuarioController implements UsuarioIController {
   private final UsuarioService usuarioService;
   
   @Override
    public Usuario cadastrar(Usuario usuario, PerfilUsuarioEnums perfil) {
        usuario.setPerfil(perfil);
        return usuarioService.save(usuario);
    }
    
    @Override
    public Usuario autenticar(String login, String senha) {
        return usuarioService.validarLogin(login, senha);
    }
    
}
