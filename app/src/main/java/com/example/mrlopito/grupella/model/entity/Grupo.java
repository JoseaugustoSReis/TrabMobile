package com.example.mrlopito.grupella.model.entity;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;


public class Grupo implements Serializable{


    private int codGrupo;
    private String nome;
    private String descricao;
    private String photoURL;
    private Boolean publico;
    private List<User> participantes;
    private User userInicial;

    public Grupo(int id_moderador, String nome, String descricao, Boolean publico,String photoURL, User user) {
        this.codGrupo = id_moderador;
        this.nome = nome;
        this.descricao = descricao;
        this.publico = publico;
        this.photoURL = photoURL;
        this.userInicial = user;
        this.participantes = new LinkedList<User>();
        this.participantes.add(this.userInicial);


    }

    public int getCodeGrupo() {
        return codGrupo;
    }

    public void setCodGrupo(int id_moderador) {
        this.codGrupo = id_moderador;
    }

    public String getPhotoURL() {
        return photoURL;
    }

    public void setPhotoURL(String photoURL) {
        this.photoURL = photoURL;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Boolean getPublico() {
        return publico;
    }

    public void setPublico(Boolean publico) {
        this.publico = publico;
    }

    @Override
    public String toString() {
        return "Curso: " + nome + " Descrição: " +
                descricao + " publico: " + publico;
    }
}
