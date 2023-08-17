package com.ControleAcessoMundoSENAI.ControleAcesso.Controller;

import com.ControleAcessoMundoSENAI.ControleAcesso.Model.M_Resposta;
import com.ControleAcessoMundoSENAI.ControleAcesso.Service.S_Pessoa;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
        // Controller passar para o serviço para tratar a validação lógica. O Service fará a checagem com o Repository buscar os dados. Retorna ao serviço
        // Ao não encontrar as informações, será impedido o login
        // Deverá criar um método com a Session para manter o usuário logado e não precisar logar a cada página acessada. A sessão expira por um tempo determinado
        // se não estiver ativo. Foi para isso que foi feito a importação do session
    }

    @GetMapping("/cadastro")
    public String getCadastro() {
        return "Cad_pessoa/cad_pessoa";
    }

    @PostMapping("/cadastro")
    public String postCadastro(@RequestParam("nome") String nome,
                               @RequestParam("cpf") String cpf,
                               @RequestParam("telefone") String telefone,
                               @RequestParam("email") String email,
                               @RequestParam("senha") String senha,
                               @RequestParam("confSenha") String confSenha,
                               RedirectAttributes redirectAttributes) {
        M_Resposta m_resposta = S_Pessoa.cadastrarPessoa(nome, cpf, email, telefone, senha, confSenha);

        if (m_resposta.getStatus()) {
            redirectAttributes.addFlashAttribute("mensagem", m_resposta.getMensagem());
            return "redirect:/";
        } else {
            redirectAttributes.addFlashAttribute("mensagem", m_resposta.getMensagem());
            redirectAttributes.addFlashAttribute("nome", nome);
            redirectAttributes.addFlashAttribute("cpf", cpf);
            redirectAttributes.addFlashAttribute("telefone", telefone);
            redirectAttributes.addFlashAttribute("email", email);
            redirectAttributes.addFlashAttribute("senha", senha);
            return "redirect:/cadastro";
        }
    }
}