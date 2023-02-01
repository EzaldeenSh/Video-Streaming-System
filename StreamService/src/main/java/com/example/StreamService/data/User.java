package com.example.StreamService.data;

public class User {
    private String Username;
    private String Password;

    public User(String username, String password) {
        Username = username;
        Password = password;
    }

    public String getUsername() {
        return Username;
    }

    public String getPassword() {
        return Password;
    }
}
