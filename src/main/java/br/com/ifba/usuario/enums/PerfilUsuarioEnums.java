/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package br.com.ifba.usuario.enums;

/**
 *
 * @author ketli
 */
//Enum que define os perfis de usuário do sistema
public enum PerfilUsuarioEnums {
    ADMIN("Administrador"),
    INSTRUTOR("Instrutor"),
    ALUNO("Aluno"),
    RECEPCIONISTA("Recepcionista");
    
    private String nome;

    PerfilUsuarioEnums(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
    

