package com.ControleAcessoMundoSENAI.ControleAcesso.Controller;

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

    /*
    @GetMapping("/cadastro")
    public String getCadastro(){
        return "Cad_Pessoa/cad_pessoa";
    }

    @PostMapping("/cadastro")
    public String postCadastro(@RequestParam("nome") String nome,
                                  @RequestParam("cpf") int cpf,
                                  @RequestParam("email") String email,
                                  @RequestParam("telefone") int telefone,
                                  @RequestParam("senha") String senha,
                                  @RequestParam("confSenha") String confSenha) {
        return "";
    }
*/
}