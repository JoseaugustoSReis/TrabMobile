package com.example.mrlopito.grupella.model.entity;

public class TexteMessage extends Message {
    private String msg;

    public TexteMessage(long codMessage, User fromUser, String msg) {
        super(codMessage, fromUser);
        this.msg = msg;
    }
    
}
