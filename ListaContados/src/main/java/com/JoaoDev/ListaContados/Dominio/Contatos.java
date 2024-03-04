package com.JoaoDev.ListaContados.Dominio;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity(name = "contatos")
public class Contatos extends EnityID{
    @Column(name = "nome")
    private String nome;
    @Column(name = "ddd")
    private String ddd;
    @Column(name = "numero")
    private String numero;
    @Column(name = "email")
    private String email;

    public Contatos() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
