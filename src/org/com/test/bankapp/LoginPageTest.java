package org.com.test.bankapp;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

import org.com.bankapp.BankService;
import org.com.bankapp.User;


public class LoginPageTest {
    private final BankService bankService = new BankService();

    @Test
    public void testAdminLogin() {
        // Validate admin credentials
        boolean validAdmin = bankService.validateAdmin("admin", "admin123");
        assertTrue(validAdmin, "Admin login should validate successfully.");
    }

    @Test
    public void testUserLogin() {
        // Validate user credentials
        User user = bankService.validateUser("user1", "userpass");
        assertNotNull(user, "Valid user credentials should return a user object.");
    }

    @Test
    public void testInvalidLogin() {
        // Validate invalid credentials
        boolean validAdmin = bankService.validateAdmin("invalidAdmin", "wrongPassword");
        User invalidUser = bankService.validateUser("invalidUser", "wrongPassword");
        assertFalse(validAdmin, "Invalid admin credentials should not validate.");
        assertNull(invalidUser, "Invalid user credentials should not validate.");
    }
}