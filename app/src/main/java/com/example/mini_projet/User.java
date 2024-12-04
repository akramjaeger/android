package com.example.mini_projet;


public class User {
    private String userId; // Firebase Auth User ID
    private String name; // User's name
    private String email; // User's email

    // Default constructor required for Firebase
    public User() {
    }

    // Parameterized constructor
    public User(String userId, String name, String email) {
        this.userId = userId;
        this.name = name;
        this.email = email;
    }

    // Getters and setters
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
