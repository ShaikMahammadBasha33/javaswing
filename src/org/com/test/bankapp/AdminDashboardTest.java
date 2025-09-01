package org.com.test.bankapp;

import org.com.bankapp.Account;
import org.com.bankapp.AdminDashboard;
import org.com.bankapp.BankService;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.swing.*;
import java.lang.reflect.Method;

public class AdminDashboardTest {

    private BankService bankService;
    private AdminDashboard adminDashboard;

    @BeforeMethod
    public void setup() {
        System.setProperty("java.awt.headless", "true"); // run Swing headless
        bankService = new BankService();
        adminDashboard = new AdminDashboard(bankService);
        adminDashboard.show(); // build UI
    }

    @Test
    public void testRefreshTableAndFilter() {
        // Add some users
        bankService.addUser("u1", "p1", "User", new Account("A1", 1000, "Savings"));
        bankService.addUser("u2", "p2", "User", new Account("A2", 500, "Current"));

        // Refresh table
        adminDashboard.refreshTable();

        // Filter by account type
        adminDashboard.filterByAccountType("Savings");
        adminDashboard.filterByAccountType("Current");

        Assert.assertTrue(bankService.getUsers().size() >= 2);
    }

    @Test
    public void testAddAndDeleteUser() {
		// Add user
		boolean added = bankService.addUser("newUser", "newPass", "User", new Account("A3", 300, "Savings"));
		Assert.assertTrue(added, "User should be added successfully.");

		// Delete user
		boolean deleted = bankService.deleteUser("newUser");
		Assert.assertTrue(deleted, "User should be deleted successfully.");
	}
}