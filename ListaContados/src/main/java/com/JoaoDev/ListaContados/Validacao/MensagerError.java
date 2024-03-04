package com.JoaoDev.ListaContados.Validacao;
public class MensagerError {
    private int code;
    private String mensagem;

    public MensagerError(int code, String mensagem) {
        this.code = code;
        this.mensagem = mensagem;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
