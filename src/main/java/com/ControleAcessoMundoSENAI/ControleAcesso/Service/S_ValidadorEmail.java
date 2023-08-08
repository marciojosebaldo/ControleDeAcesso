package com.ControleAcessoMundoSENAI.ControleAcesso.Service;

import java.util.regex.*;

import org.springframework.stereotype.Service;

@Service
public class S_ValidadorEmail {
    public static boolean validatePassword(String senha) {
        // Verifica se a senha possui pelo menos 8 caracteres, contém letras maiúsculas,
        // minúsculas e dígitos
        String passwordPattern = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}$";
        return Pattern.matches(passwordPattern, senha);
    }

    public static boolean passwordsMatch(String senha, String confSenha) {
        return senha.equals(confSenha);
    }
}