package com.library.govLibrary.model;

import lombok.Getter;

public class Credentials {
    private String username;
    private char[] password;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return String.valueOf(password);
    }
}
