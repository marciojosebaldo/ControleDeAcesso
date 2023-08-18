package com.ControleAcessoMundoSENAI.ControleAcesso.Service;

import com.ControleAcessoMundoSENAI.ControleAcesso.Model.M_Pessoa;
import com.ControleAcessoMundoSENAI.ControleAcesso.Repository.R_Pessoa;
import org.springframework.stereotype.Service;

@Service
public class S_Login {

    private static R_Pessoa r_pessoa;

    // This é utilizado porque temos dois nomes iguais. Se fosse R_Pessoa rpessoa, não precisaria ter o this.
    public S_Login(R_Pessoa r_pessoa) {
        this.r_pessoa = r_pessoa;
    }

    // Retorna M_Pessoa porque os dados serão enviados para a Session
    public static M_Pessoa validaLogin(String cpf, String senha) {
        Long nCpf;

        if(S_LimpaNumero.limpar(cpf).equals("")) {
            nCpf = null;
        } else {
            nCpf = Long.valueOf(S_LimpaNumero.limpar(cpf));
        }
        return r_pessoa.findByCpfESenha(nCpf, senha);
    }
}
