package com.example.mrlopito.grupella.model.entity;

import com.example.mrlopito.grupella.model.dao.ConfiguracaoFirebase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Exclude;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;


public class Grupo implements Serializable{


    private int id_moderador;
    private String nome;
    private String descricao;
    private String photoURL;
    private Boolean publico;

    public Grupo(int id_moderador, String nome, String descricao, Boolean publico,String photoURL) {
        this.id_moderador = id_moderador;
        this.nome = nome;
        this.descricao = descricao;
        this.publico = publico;
        this.photoURL = photoURL;
    }

    public int getId_moderador() {
        return id_moderador;
    }

    public void setId_moderador(int id_moderador) {
        this.id_moderador = id_moderador;
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


    public void insert() {
        DatabaseReference databaseReference = ConfiguracaoFirebase.getFirebase();
        databaseReference.child("grupo").child(String.valueOf(getId_moderador())).setValue(this);
    }

    @Exclude
    public Map<String, Object> toMap(){
        HashMap<String, Object> hashUser = new HashMap<>();
        hashUser.put("id_moderador", getId_moderador());
        hashUser.put("nome", getNome());
        hashUser.put("imagem", getPhotoURL());
        hashUser.put("publico", getPublico());
        return hashUser;
    }
}
