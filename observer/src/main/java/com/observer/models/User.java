package com.observer.models;

import java.util.UUID;

/**
 * Created by abhimanyus on 2/21/18.
 */
public class User {

    private String name;
    private UUID id;
    private String emailId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
}
