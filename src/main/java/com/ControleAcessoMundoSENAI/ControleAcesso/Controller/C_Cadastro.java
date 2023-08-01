package com.ControleAcessoMundoSENAI.ControleAcesso.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class C_Cadastro {

    @GetMapping("/cadastro")
    public String cadastro(){
        return "Cadastro/cad_pessoa";
    }

    @PostMapping("/cadastro")
    public String cadastrarPessoa(@RequestParam("id") String id,
                                  @RequestParam("nome") String nome,
                                  @RequestParam("cpf") int cpf,
                                  @RequestParam("email") String email,
                                  @RequestParam("telefone") int telefone,
                                  @RequestParam("senha") String senha,
                                  @RequestParam("confSenha") String confSenha) {
        return "Cadastro/cad_pessoa";
    }
}