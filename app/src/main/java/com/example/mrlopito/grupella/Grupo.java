package com.example.mrlopito.grupella;

public class Grupo {
    private String nome;
    private String descricao;
    private Boolean publico;

    public Grupo(String nome, String descricao, Boolean publico) {
        this.nome = nome;
        this.descricao = descricao;
        this.publico = publico;
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
