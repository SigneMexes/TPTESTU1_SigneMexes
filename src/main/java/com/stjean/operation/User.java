package com.stjean.operation;

import java.util.ArrayList;

public class User {
    private int id;
    private String name;
    private int age;
    private String email;
    private String phone;
    private String city;
    private double balancePersonnel;
    public static ArrayList<User> users = new ArrayList<>();

    // Constructor, getters, and setters
    public User(int id, String name, int age, String email, String phone, String city, double balancePersonnel) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.phone = phone;
        this.city = city;
        this.balancePersonnel = balancePersonnel;
    }
    
    public void add(User user) throws EmailInvalidException {
        if (!isValidEmail(user.email)) {
            throw new EmailInvalidException("Invalid email address.");
        }
        users.add(user);
    }

    public void delete(int id) throws DeletionInvalidException {
        User user = findUserById(id);
        if (user == null) {
            throw new DeletionInvalidException("User not found for deletion.");
        }
        users.remove(user);
    }

    public ArrayList<User> list() {
        return users;
    }

    public User display(int id) {
        return findUserById(id);
    }

    // Helper method to find user by ID
    private User findUserById(int id) {
        return users.stream().filter(user -> user.id == id).findFirst().orElse(null);
    }

    // Email validation method
    private boolean isValidEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        return email.matches(emailRegex);
    }


    // Getters and setters for each field
}
