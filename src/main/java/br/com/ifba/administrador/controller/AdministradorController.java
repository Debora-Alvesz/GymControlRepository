/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.administrador.controller;

import br.com.ifba.administrador.entity.Administrador;
import br.com.ifba.administrador.service.AdministradorIService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 *
 * @author João Victor
 */
@Controller
public class AdministradorController implements AdministradorIController{
    
    //Instância da camada Service
    @Autowired
    private AdministradorIService administradorService;
    
    //Método para salvar administrador
    @Override
    public Administrador save(Administrador administrador){   
    return administradorService.save(administrador);
    }
    
    //Método para listar administradores
    @Override
    public List<Administrador> findAll(){        
    return administradorService.findAll();
    }

    //Método para deletar administrador
    @Override
    public void delete(Administrador administrador){
    administradorService.delete(administrador);
    }

    // Método específico para atualização
    @Override
    public Administrador update(String cpf, Administrador administrador){   
    return administradorService.update(cpf, administrador);
    }
}
