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

    public static String cadastrarPessoa(String nome, String cpf, String email, String telefone, String senha, String confSenha) {

        String mensagem = "";
        boolean podeSalvar = true;

        if (!senha.equals(confSenha) || senha == null || senha.trim().equals("")) {
            mensagem += "Senha e confirmação devem ser iguais ou a senha deve ser informada";
            podeSalvar = false;
        }

        if (!S_ValidadorCPF.validarCpf(cpf)) {
            mensagem += "CPF inválido";
            podeSalvar = false;
        }

        if (nome == null || nome.trim().equals("")) {
            mensagem += "O nome precisa ser informado";
            podeSalvar = false;
        }

        if ((email == null || email.trim().equals("")) && (telefone == null || telefone.trim().equals(""))) {
            mensagem += "E-mail ou telefone precisa ser informado";
            podeSalvar = false;
        }

        if (podeSalvar) {
            M_Pessoa m_pessoa = new M_Pessoa();
            m_pessoa.setNome(nome);
            m_pessoa.setCpf(Long.valueOf(S_LimpaNumero.limpar(cpf)));
            m_pessoa.setEmail(email);
            m_pessoa.setTelefone(Long.valueOf(S_LimpaNumero.limpar(telefone)));
            m_pessoa.setSenha(senha);
            r_pessoa.save(m_pessoa);
            mensagem += "Cadastro realizado com sucesso";
        }

        return mensagem;
    }
}