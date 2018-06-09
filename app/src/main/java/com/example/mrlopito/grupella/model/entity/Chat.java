package com.example.mrlopito.grupella.model.entity;

public class Chat {
    private long codChat;
    private Grupo grupo;
    private long numberOfMsg;

    public Chat(long codChat, Grupo grupo) {
        this.codChat = codChat;
        this.grupo = grupo;
        this.numberOfMsg = 0;
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
