package com.example.mrlopito.grupella.model.entity;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

public abstract class Message {
    private long codMessage;
    private User fromUser;
    private Date dataEnvio;

    public Message(long codMessage, User fromUser) {
        this.codMessage = codMessage;
        this.fromUser = fromUser;
        this.dataEnvio = Calendar.getInstance().getTime();
    }

    public long getCodMessage() {
        return codMessage;
    }

    public void setCodMessage(long codMessage) {
        this.codMessage = codMessage;
    }

    public User getFromUser() {
        return fromUser;
    }

    public void setFromUser(User fromUser) {
        this.fromUser = fromUser;
    }
}
