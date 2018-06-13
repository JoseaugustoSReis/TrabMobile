package com.example.mrlopito.grupella.model.entity;

import java.io.Serializable;

public class ParticipantesGrupo implements Serializable {
    private Grupo grupo;
    private User user;

    public ParticipantesGrupo(Grupo grupo, User user) {
        this.grupo = grupo;
        this.user = user;
    }
    public ParticipantesGrupo(){

    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
