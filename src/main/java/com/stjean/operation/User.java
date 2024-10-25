package com.stjean.operation;

import java.util.ArrayList;
import java.util.Comparator;

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
    
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public double getBalancePersonnel() {
		return balancePersonnel;
	}

	public void setBalancePersonnel(double balancePersonnel) {
		this.balancePersonnel = balancePersonnel;
	}

	public static ArrayList<User> getUsers() {
		return users;
	}

	public static void setUsers(ArrayList<User> users) {
		User.users = users;
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
    
    public double analyseSoldeGeneral() throws NegativeGeneralBalanceException {
        double totalBalance = users.stream().mapToDouble(User::getBalancePersonnel).sum();
        if (totalBalance < 0) {
            throw new NegativeGeneralBalanceException("General balance is negative.");
        }
        return totalBalance;
    }

    public User richestUser() {
        return users.stream().max(Comparator.comparingDouble(User::getBalancePersonnel)).orElse(null);
    }


}
