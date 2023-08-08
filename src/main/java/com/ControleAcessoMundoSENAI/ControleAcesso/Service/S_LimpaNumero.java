package com.ControleAcessoMundoSENAI.ControleAcesso.Service;

import org.springframework.stereotype.Service;

@Service
public class S_LimpaNumero {

    public static String limpar(String numero) {
        // Remova caracteres não numéricos do CPF
        return numero.replaceAll("[^0-9]", "");
    }
}