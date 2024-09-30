/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main;

import java.util.Scanner;

/**
 *
 * @author RC_Student_lab
 */
public class Login {
    public static void main(String[] args) {

    // Create an instance of the Login class to access user registration and login functionality
    Main system = new Main();
    
    // Initialize the Scanner to capture user input from the console
    Scanner sc = new Scanner(System.in);

    // Variable to track if an account has been successfully created
    boolean AccountCreated = false;

    // Prompt the user to create an account
    System.out.println("Please create an account");

    // Loop until the user successfully creates an account
    while (!AccountCreated) {
        // Prompt for the user's first name and store it in the system
        System.out.print("Enter first name: ");
        String firstName = sc.nextLine();
        system.setFirstName(firstName);

        // Prompt for the user's last name and store it in the system
        System.out.print("Enter last name: ");
        String lastName = sc.nextLine();
        system.setLastName(lastName);

        // Prompt for the username and store it, applying the required username format
        System.out.print("Enter username: ");
        String username = sc.nextLine();
        system.setUsername(username);

        // Prompt for the password and store it, applying the required password complexity rules
        System.out.print("Enter password: ");
        String password = sc.nextLine();
        system.setPassword(password);

        // Check if the username and password meet the required criteria
        String registrationStatus = system.registerUser();
        System.out.println(registrationStatus); // Display registration status

        // If both username and password are valid, create the account and exit the loop
        if (registrationStatus.contains("successfully")) {
            system.Accountcreation(username, password, firstName, lastName);
            AccountCreated = true;
        }
    }

    // Proceed to login after successful account creation
    System.out.println("Login:");

    // Variable to track if the user has logged in successfully
    boolean loginStatus = false;

    // Keep prompting for the username and password until login is successful
    while (!loginStatus) {
        // Prompt the user for their username and password
        System.out.print("Enter username: ");
        String loginUsername = sc.nextLine();

        System.out.print("Enter password: ");
        String loginPassword = sc.nextLine();

        // Attempt to log the user in
        loginStatus = system.loginUser(loginUsername, loginPassword);

        // Display the login status message (success or failure)
        String loginMessage = system.LoginStatus(loginStatus);
        System.out.println(loginMessage);
    }
}
}
