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
    public static boolean isCpfValido(String cpf) {
    if (cpf == null) return false;

    // 1. Limpeza
    String cpfLimpo = cpf.replaceAll("[^0-9]", "");

    // 2. Tamanho e Repetidos
    if (cpfLimpo.length() != 11 || cpfLimpo.matches("(\\d)\\1{10}")) {
        return false;
    }

    // 3. Cálculo Oficial (Padrão Receita Federal)
    try {
        char dig10, dig11;
        int sm, i, r, num, peso;

        // Calculo do 1o. Digito Verificador
        sm = 0;
        peso = 10;
        for (i = 0; i < 9; i++) {
            // Converte o char para int (48 é o código ASCII do '0')
            num = (int) (cpfLimpo.charAt(i) - 48);
            sm = sm + (num * peso);
            peso = peso - 1;
        }

        r = 11 - (sm % 11);
        if ((r == 10) || (r == 11)) {
            dig10 = '0';
        } else {
            // Converte int para char
            dig10 = (char) (r + 48);
        }

        // Calculo do 2o. Digito Verificador
        sm = 0;
        peso = 11;
        for (i = 0; i < 10; i++) {
            num = (int) (cpfLimpo.charAt(i) - 48);
            sm = sm + (num * peso);
            peso = peso - 1;
        }

        r = 11 - (sm % 11);
        if ((r == 10) || (r == 11)) {
            dig11 = '0';
        } else {
            dig11 = (char) (r + 48);
        }

        // Verifica se os calculados batem com os digitados
        if ((dig10 == cpfLimpo.charAt(9)) && (dig11 == cpfLimpo.charAt(10))) {
            return true;
        } else {
            return false;
        }

    } catch (Exception e) {
        return false;
    }
}
}  
