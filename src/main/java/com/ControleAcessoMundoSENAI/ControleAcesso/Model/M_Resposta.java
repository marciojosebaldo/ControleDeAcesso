package com.ControleAcessoMundoSENAI.ControleAcesso.Model;

// Método do Java nativo. É um modelo porque agirá como Serviço

public class M_Resposta {
    private boolean status;
    private String mensagem;

    public M_Resposta(boolean status, String mensagem) {
        this.status = status;
        this.mensagem = mensagem;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}