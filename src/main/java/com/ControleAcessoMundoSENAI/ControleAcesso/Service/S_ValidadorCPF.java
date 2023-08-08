package com.ControleAcessoMundoSENAI.ControleAcesso.Service;

import org.springframework.stereotype.Service;

@Service
public class S_ValidadorCPF {

        public static boolean validarCpf(String cpf) {
            // Remova caracteres não numéricos do CPF
            cpf = S_LimpaNumero.limpar(cpf);

            // Verifica se o CPF possui 11 dígitos
            if (cpf.length() != 11) {
                return false;
            }

            // Calcula o primeiro dígito verificador
            int sum = 0;
            for (int i = 0; i < 9; i++) {
                sum += Character.getNumericValue(cpf.charAt(i)) * (10 - i);
            }
            int digit1 = 11 - (sum % 11);
            if (digit1 >= 10) {
                digit1 = 0;
            }

            // Calcula o segundo dígito verificador
            sum = 0;
            for (int i = 0; i < 10; i++) {
                sum += Character.getNumericValue(cpf.charAt(i)) * (11 - i);
            }
            int digit2 = 11 - (sum % 11);
            if (digit2 >= 10) {
                digit2 = 0;
            }

            // Verifica se os dígitos verificadores calculados são iguais aos dígitos do CPF
            return Character.getNumericValue(cpf.charAt(9)) == digit1 && Character.getNumericValue(cpf.charAt(10)) == digit2;
        }
}

