/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.main;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author RC_Student_lab
 */
public class LoginTest {
    public class LoginTestTest {

    private Main system;

    @BeforeEach
    public void setup() {
        system = new Main();
    }

    @Test
    public void testUsernameCorrectlyFormatted() {
        system.setUsername("kyl_1");
        assertTrue(system.checkusername(), "Username should follow the correct format");
    }

    @Test
    public void testUsernameIncorrectlyFormatted() {
        system.setUsername("kyle!!!!!!!");
        assertFalse(system.checkusername(), "Username should not meet the formatting criteria");
    }

    @Test
    public void testPasswordMeetsComplexityRequirements() {
        system.setPassword("Ch&&sec@ke99!");
        assertTrue(system.Passwordcomplexity(), "Password should meet the complexity rules");
    }

    @Test
    public void testPasswordDoesNotMeetComplexityRequirements() {
        system.setPassword("password");
        assertFalse(system.Passwordcomplexity(), "Password should not meet the complexity criteria");
    }

    @Test
    public void testRegisterUserValidUsernameAndPassword() {
        system.setUsername("kyl_1");
        system.setPassword("Ch&&sec@ke99!");
        String registrationStatus = system.registerUser();
        assertEquals("Username successfully captured\nPassword successfully captured", registrationStatus, 
                     "Valid username and password should result in successful registration");
    }

    @Test
    public void testRegisterUserInvalidUsername() {
        system.setUsername("kyle!!!!!!!");
        system.setPassword("Ch&&sec@ke99!");
        String registrationStatus = system.registerUser();
        assertEquals("Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.", 
                     registrationStatus, 
                     "Invalid username should prevent registration");
    }

    @Test
    public void testRegisterUserInvalidPassword() {
        system.setUsername("kyl_1");
        system.setPassword("password");
        String registrationStatus = system.registerUser();
        assertEquals("Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number and a special character.", 
                     registrationStatus, 
                     "Invalid password should prevent registration");
    }

    @Test
    public void testLoginSuccess() {
        system.Accountcreation("kyl_1", "Ch&&sec@ke99!", "John", "Doe");
        boolean loginStatus = system.loginUser("kyl_1", "Ch&&sec@ke99!");
        assertTrue(loginStatus, "Login should succeed with correct credentials");
    }

    @Test
    public void testLoginFailure() {
        system.Accountcreation("kyl_1", "Ch&&sec@ke99!", "John", "Doe");
        boolean loginStatus = system.loginUser("kyl_1", "wrongpassword");
        assertFalse(loginStatus, "Login should fail with incorrect password");
    }

    @Test
    public void testReturnLoginStatusSuccess() {
        system.Accountcreation("kyl_1", "Ch&&sec@ke99!", "John", "Doe");
        boolean loginStatus = system.loginUser("kyl_1", "Ch&&sec@ke99!");
        String loginMessage = system.LoginStatus(loginStatus);
        assertEquals("Welcome John, Doe it is great to see you again.", 
                     loginMessage, "Successful login should return a welcome message");
    }

    @Test
    public void testReturnLoginStatusFailure() {
        system.Accountcreation("kyl_1", "Ch&&sec@ke99!", "John", "Doe");
        boolean loginStatus = system.loginUser("kyl_1", "wrongpassword");
        String loginMessage = system.LoginStatus(loginStatus);
        assertEquals("Username or password incorrect, please try again", 
                
                     loginMessage, "Failed login should return an error message");
    }
}
}
