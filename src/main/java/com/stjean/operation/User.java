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

    // Getters and setters for each field
}
