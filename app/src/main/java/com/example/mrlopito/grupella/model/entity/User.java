package com.example.mrlopito.grupella.model.entity;

import com.example.mrlopito.grupella.model.dao.ConfiguracaoFirebase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Exclude;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class User {
    private String cod;
    private String nome;
    private String email;
    private String senha;
    private long idUser;
    public User(String cod, String nome, String email, String senha) {
        this.cod = cod;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.idUser = gerarId();
    }

    private long gerarId() {
        long id = new Random().nextInt(9)+1;

        id = (id)*90000;
        return id;


    }

    public long getIdUser() {
        return idUser;
    }

    public User(){

    }
    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void insert() {
        DatabaseReference databaseReference = ConfiguracaoFirebase.getFirebase();
        databaseReference.child("user").child(String.valueOf(getCod())).setValue(this);
    }

    @Exclude
    public Map<String, Object> toMap(){
        HashMap<String, Object> hashUser = new HashMap<>();
        hashUser.put("cod", getCod());
        hashUser.put("nome", getNome());
        hashUser.put("email", getEmail());
        hashUser.put("senha", getSenha());
        return hashUser;
    }
}
