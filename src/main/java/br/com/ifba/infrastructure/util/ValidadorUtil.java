/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.infrastructure.util;

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
    
     // Verifica se o CPF é válido (11 dígitos + dígitos verificadores)
    public static boolean isValidCPF(String cpf) {
        if (isNullOrEmpty(cpf)) {
            return false;
        }
        
        // Remove pontos e traço
        cpf = cpf.replace(".", "").replace("-", "");

        // Deve conter exatamente 11 números
        if (!cpf.matches("\\d{11}")) {
            return false;
        }

        // Evita CPFs com todos os números iguais
        if (cpf.chars().distinct().count() == 1) {
            return false;
        }

        try {
            int soma = 0;
            int peso = 10;

            // Primeiro dígito verificador
            for (int i = 0; i < 9; i++) {
                soma += (cpf.charAt(i) - '0') * peso--;
            }

            int resto = (soma * 10) % 11;
            resto = (resto == 10) ? 0 : resto;

            if (resto != (cpf.charAt(9) - '0')) {
                return false;
            }

            soma = 0;
            peso = 11;

            // Segundo dígito verificador
            for (int i = 0; i < 10; i++) {
                soma += (cpf.charAt(i) - '0') * peso--;
            }

            resto = (soma * 10) % 11;
            resto = (resto == 10) ? 0 : resto;

            return resto == (cpf.charAt(10) - '0');

        } catch (Exception e) {
            return false;
        }
    }
}
