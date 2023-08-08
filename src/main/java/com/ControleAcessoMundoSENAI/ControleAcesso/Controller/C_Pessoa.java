package com.ControleAcessoMundoSENAI.ControleAcesso.Controller;

import com.ControleAcessoMundoSENAI.ControleAcesso.Service.S_Pessoa;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class C_Pessoa {

    @GetMapping("/")
    public String landPage() {
        return "Login/login";
    }

    @PostMapping("/")
    public String loginPessoa(@RequestParam("usuario") String usuario,
                              @RequestParam("senha") String senha) {
        return "Home/home";
    }

    @GetMapping("/cadastro")
    public String getCadastro(){
        return "Cad_pessoa/cad_pessoa";
    }

    @PostMapping("/cadastro")
    public String postCadastro(@RequestParam("nome") String nome,
                               @RequestParam("cpf") String cpf,
                               @RequestParam("telefone") String telefone,
                               @RequestParam("email") String email,
                               @RequestParam("senha") String senha,
                               @RequestParam("confSenha") String confSenha) {
        S_Pessoa.cadastrarPessoa(nome, cpf, email, telefone,senha, confSenha);
        return "redirect:/";
    }
}