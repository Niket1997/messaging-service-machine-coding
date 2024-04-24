package org.rio.entities;

import lombok.Data;

@Data
public class User {
    String id;
    String name;
    long createdAt;

    public User(String id, String name) {
        this.id = id;
        this.name = name;
        createdAt = System.currentTimeMillis();
    }
}
