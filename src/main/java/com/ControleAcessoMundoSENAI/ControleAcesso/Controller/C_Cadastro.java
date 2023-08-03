package com.ControleAcessoMundoSENAI.ControleAcesso.Controller;

import com.ControleAcessoMundoSENAI.ControleAcesso.Service.S_Pessoa;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class C_Cadastro {

    @GetMapping("/cadastro")
    public String cadastro(){
        return "Cad_Pessoa/cad_pessoa";
    }

    @PostMapping("/cadastro")
    public String cadastrarPessoa(@RequestParam("id") String id,
                                  @RequestParam("nome") String nome,
                                  @RequestParam("cpf") String cpf,
                                  @RequestParam("email") String email,
                                  @RequestParam("telefone") String telefone,
                                  @RequestParam("senha") String senha) {
        S_Pessoa.cadastrarPessoa(nome, cpf, email, telefone, senha);
        return "redirect:/";
    }
}