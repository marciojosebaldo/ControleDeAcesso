package com.ControleAcessoMundoSENAI.ControleAcesso.Service;

import com.ControleAcessoMundoSENAI.ControleAcesso.Model.M_Pessoa;
import com.ControleAcessoMundoSENAI.ControleAcesso.Repository.R_Pessoa;
import org.springframework.stereotype.Service;

@Service
public class S_Pessoa {
    private static R_Pessoa r_pessoa;

    public S_Pessoa(R_Pessoa r_pessoa) {
        this.r_pessoa = r_pessoa;
    }

    public static String cadastrarPessoa(String nome, String cpf, String email, String telefone, String senha) {

        M_Pessoa m_pessoa = new M_Pessoa();
        m_pessoa.setNome(nome);
        m_pessoa.setCpf(Long.valueOf(cpf)); /*Converte o long para String*/
        m_pessoa.setEmail(email);
        m_pessoa.setTelefone(Long.valueOf(telefone));
        m_pessoa.setSenha(senha);
        r_pessoa.save(m_pessoa);

        return "Cadastro realizado com suscesso";
    }
}