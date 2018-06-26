package com.example.mrlopito.grupella.model.entity;

public class TexteMessage{
    private User user;
    private String msg;
    private long cod;


    public User getUser() {
        return user;
    }

    public long getCod() {
        return cod;
    }

    public TexteMessage(long codMessage, User fromUser, String msg) {
        this.cod = codMessage;
        this.user = fromUser;
        this.msg = msg;


    }

    public String getMsg() {
        return msg;
    }



}
