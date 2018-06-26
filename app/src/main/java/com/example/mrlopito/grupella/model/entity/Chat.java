package com.example.mrlopito.grupella.model.entity;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Chat {
    private long codChat;
    private Grupo grupo;
    private long numberOfMsg;

    private List<Message> msgs;

    public Chat(long codChat, Grupo grupo) {

        this.codChat = codChat;
        this.grupo = grupo;
        this.numberOfMsg = 0;
        this.msgs = new ArrayList<Message>();
    }

    public long getCodChat() {
        return codChat;
    }

    public void setCodChat(long codChat) {
        this.codChat = codChat;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public long getNumberOfMsg() {
        return numberOfMsg;
    }

    public void setNumberOfMsg(long numberOfMsg) {
        this.numberOfMsg = numberOfMsg;
    }
}
