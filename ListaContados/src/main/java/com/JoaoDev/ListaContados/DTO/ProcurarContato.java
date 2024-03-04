package com.JoaoDev.ListaContados.DTO;

public class ProcurarContato {

    //Parametro visa receber qualquer tipo de entrada de Dado para procurar na Lista e exibir correspondente
    private String procurar;

    public ProcurarContato() {
    }

    public String getProcurar() {
        return procurar;
    }

    public void setProcurar(String procurar) {
        this.procurar = procurar;
    }
}
