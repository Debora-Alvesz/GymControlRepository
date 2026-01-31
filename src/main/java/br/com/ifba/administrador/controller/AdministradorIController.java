/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.ifba.administrador.controller;

import br.com.ifba.administrador.entity.Administrador;
import java.util.List;


/**
 *
 * @author João Victor
 */
public interface AdministradorIController {
    
    //Método para salvar Administrador
    Administrador save(Administrador administrador);
    
    //Método para listar Administradores
    List<Administrador> findAll();
    
    //Método para deletar Administrador
    void delete(Administrador administrador);
    
    // Método específico para atualização
    Administrador update(String cpf, Administrador administrador);
}
