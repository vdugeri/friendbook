package com.danverem.friendster.dtos;

import java.io.Serializable;

public class UserToken implements Serializable {
    private String token;
    private UserDTO user;

    public String getToken() {
        return token;
    }

    public UserToken setToken(String token) {
        this.token = token;

        return this;
    }

    public UserDTO getUser() {
        return user;
    }

    public UserToken setUser(UserDTO user) {
        this.user = user;

        return this;
    }
}
