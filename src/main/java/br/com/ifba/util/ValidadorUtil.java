package br.com.ifba.util;

//Classe utilitária para validações básicas
public class ValidadorUtil {


    //Valida se o valor informado é nulo
    public static void validarNaoNulo(Object valor, String nomeCampo) {

        if (valor == null) {
            throw new IllegalArgumentException(
                    "O campo '" + nomeCampo + "' não pode ser nulo."
            );
        }
    }
}
