/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.util;

/**
 *
 * @author ricle
 */
public class ValidadorUtil {
    
     // Verifica se uma string é nula ou vazia (incluindo espaços em branco)
    public static boolean isNullOrEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }

    // Verifica se a string tem um comprimento mínimo
    public static boolean hasMinLength(String value, int minLength) {
        return value != null && value.trim().length() >= minLength;
    }

    // Verifica se a string tem apenas letras
    public static boolean isAlphabetic(String value) {
        return value != null && value.matches("^[a-zA-ZáéíóúÁÉÍÓÚãõÃÕçÇ\\s]+$");
    }

    // Verifica se a string tem apenas números
    public static boolean isNumeric(String value) {
        return value != null && value.matches("\\d+");
    }

    // Remove espaços extras e retorna string normalizada
    public static String normalize(String value) {
        return value == null ? null : value.trim().replaceAll("\\s+", " ");
    }

    // Verifica se um e-mail é válido
    public static boolean isValidEmail(String email) {
        return email != null && email.matches("^[\\w\\.-]+@[\\w\\.-]+\\.\\w{2,}$");
    }

    // Verifica se a string contém caracteres especiais
    public static boolean containsSpecialCharacters(String value) {
        return value != null && value.matches(".*[^a-zA-Z0-9 ].*");
    }
    
    // Verifica se o CPF é válido
  public static boolean isCpfValido(String cpf) {
    // Se for nulo ou estiver vazio, já retorna falso
    if (cpf == null || cpf.trim().isEmpty()) {
        return false;
    }

    // 1. Limpeza: Remove TUDO que não for número (pontos, traços, espaços, parênteses)
    String cpfLimpo = cpf.replaceAll("[^0-9]", "");

    // 2. Verificação: Sobraram exatamente 11 números?
    // Se sim, retorna true. Se não, retorna false.
    return cpfLimpo.length() == 11;
}

    //Valida se o valor informado é nulo
    public static void validarNaoNulo(Object valor, String nomeCampo) {

        if (valor == null) {
            throw new IllegalArgumentException(
                    "O campo '" + nomeCampo + "' não pode ser nulo."
            );
        }
    }
}
