/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.main;

/**
 *
 * @author RC_Student_lab
 */

public class Main {
    // Private fields for storing user details
    private String username;
    private String password;
    private String Firstname;
    private String Lastname;

    // Constructor to initialize the Login object with user details
    public Main (String username, String password, String Firstname, String Lastname) {
        this.username = username;
        this.password = password;
        this.Firstname = Firstname;
        this.Lastname = Lastname;
    }

    // Default constructor to allow creating an empty Login object
    public Main () {
    }

    // Boolean method to check if the username contains an underscore and is no more than 5 characters long
    public boolean checkusername() {
        return username.contains("_") && username.length() <= 5;
    }

    // Boolean method to check if the password meets the complexity requirements
    // It checks for length, uppercase letters, numbers, and special characters
    public boolean Passwordcomplexity() {
        return password.length() >= 8 &&
               password.matches(".*[A-Z].*") && // At least one uppercase letter
               password.matches(".*[0-9].*") && // At least one digit
               password.matches(".*[!@#$%^&*()_+-=].*"); // At least one special character
    }

    // Method to register the user by validating the username and password
    public String registerUser() {
        if (!checkusername()) {
            return "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.";
        }
        if (!Passwordcomplexity()) {
            return "Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number and a special character.";
        }
        return "Username successfully captured\nPassword successfully captured";
    }

    // Method to verify login by checking the provided username and password against saved values
    public boolean loginUser(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }

    // Method to return a status message after login attempt
    public String LoginStatus(boolean loginStatus) {
        if (loginStatus) {
            return "Welcome " + Firstname + ", " + Lastname + " it is great to see you again.";
        }
        return "Username or password incorrect, please try again";
    }

    // Method to create a new user account by setting the username, password, first name, and last name
    public void Accountcreation(String username, String password, String firstName, String lastName) {
        this.username = username;
        this.password = password;
        this.Firstname = Firstname;
        this.Lastname = Lastname;
        System.out.println("Account created successfully!");
    }
    
     // Setter method to assign a first name to the user
    public void setFirstName(String Firstname) {
        this.Firstname = Firstname;
    }

    // Setter method to assign a last name to the user
    public void setLastName(String Lastname) {
        this.Lastname = Lastname;
    }

    // Getter method to retrieve the first name of the user
    public String getFirstName() {
        return this.Firstname;
    }

    // Getter method to retrieve the last name of the user
    public String getLastName() {
        return this.Lastname;
    }

    // Getter method to retrieve the username of the user
    public String getUsername() {
        return this.username;
    }

    // Setter method to assign a username to the user
    public void setUsername(String username) {
        this.username = username;
    }

    // Getter method to retrieve the password of the user
    public String getPassword() {
        return this.password;
    }

    // Setter method to assign a password to the user
    public void setPassword(String password) {
        this.password = password;
    }

}
