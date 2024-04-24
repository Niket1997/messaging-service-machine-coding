package org.rio.entities;

import lombok.Data;

import java.util.UUID;

@Data
public class Message {
    String id;
    User from;
    User to;
    String text;
    boolean isRead;
    long createdAt;

    public Message(User from, User to, String text) {
        this.id = UUID.randomUUID().toString();
        this.from = from;
        this.to = to;
        this.text = text;
        this.isRead = false;
        this.createdAt = System.currentTimeMillis();
    }

    public String getId() {
        return id;
    }

    public void setRead(boolean read) {
        isRead = read;
    }

    public boolean isRead() {
        return isRead;
    }

    public User getFrom() {
        return from;
    }

    public User getTo() {
        return to;
    }
}
