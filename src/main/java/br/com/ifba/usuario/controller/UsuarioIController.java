/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.ifba.usuario.controller;

import br.com.ifba.usuario.entity.Usuario;
import br.com.ifba.usuario.enums.PerfilUsuarioEnums;

/**
 *
 * @author ketli
 */
public interface UsuarioIController {
    
     Usuario cadastrar(Usuario usuario, PerfilUsuarioEnums perfil);
     
     Usuario autenticar(String login, String senha);
}
