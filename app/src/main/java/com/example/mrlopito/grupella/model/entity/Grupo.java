package com.example.mrlopito.grupella.model.entity;

import java.io.Serializable;

<<<<<<< HEAD
public class Grupo implements Serializable{
=======

public class Grupo implements Serializable {
>>>>>>> 60417e80167cb8b3a230ef6fc8a41c1ae870ab8b

    private String nome;
    private String descricao;
    private String photoURL;
    private Boolean publico;

    public Grupo(String nome, String descricao, Boolean publico,String photoURL) {
        this.nome = nome;
        this.descricao = descricao;
        this.publico = publico;
        this.photoURL = photoURL;
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
