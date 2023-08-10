package com.ControleAcessoMundoSENAI.ControleAcesso.Service;

import com.ControleAcessoMundoSENAI.ControleAcesso.Model.M_Pessoa;
import com.ControleAcessoMundoSENAI.ControleAcesso.Model.M_Resposta;
import com.ControleAcessoMundoSENAI.ControleAcesso.Repository.R_Pessoa;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class S_Pessoa {
    private static R_Pessoa r_pessoa;

    public S_Pessoa(R_Pessoa r_pessoa) {
        this.r_pessoa = r_pessoa;
    }

    public static M_Resposta cadastrarPessoa(String nome, String cpf, String email, String telefone, String senha, String confSenha) {
        String mensagem = "";
        boolean podeSalvar = true;

        if (!senha.equals(confSenha) || senha == null || senha.trim().equals("")) {
            mensagem += "Senha e confirmação devem ser iguais ou a senha deve ser informada<br/>";
            podeSalvar = false;
        }

        if (!S_ValidadorCPF.validarCpf(cpf)) {
            mensagem += "CPF inválido<br/>";
            podeSalvar = false;
        }

        if (nome == null || nome.trim().equals("")) {
            mensagem += "O nome precisa ser informado<br/>";
            podeSalvar = false;
        }

        if ((email == null || email.trim().equals("")) && (telefone == null || telefone.trim().equals(""))) {
            mensagem += "E-mail ou telefone precisa ser informado<br/>";
            podeSalvar = false;
        }

        if (podeSalvar) {
            M_Pessoa m_pessoa = new M_Pessoa();
            m_pessoa.setNome(nome);
            m_pessoa.setCpf(Long.valueOf(S_LimpaNumero.limpar(cpf)));
            m_pessoa.setEmail(email);
            if (telefone == "") {
                m_pessoa.setTelefone(null);
            } else {
                m_pessoa.setTelefone(Long.valueOf(S_LimpaNumero.limpar(telefone)));
            }
            m_pessoa.setSenha(senha);

            try {
                r_pessoa.save(m_pessoa);
                mensagem += "Cadastro realizado com sucesso";
            } catch (DataIntegrityViolationException e) {
                mensagem += e.getMessage()+"<br/>";
                podeSalvar = false;
            }
        }
        M_Resposta m_resposta = new M_Resposta(podeSalvar, mensagem);
        return m_resposta;
    }
}