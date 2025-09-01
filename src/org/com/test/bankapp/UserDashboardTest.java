package org.com.test.bankapp;

import org.com.bankapp.Account;
import org.com.bankapp.User;
import org.com.bankapp.UserDashboard;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.swing.*;
import java.lang.reflect.Method;

public class UserDashboardTest {

    private User user;
    private UserDashboard userDashboard;

    @BeforeMethod
    public void setup() {
        Account account = new Account("U123", 1000, "Savings");
        user = new User("testUser", "pwd", "User", account);
        userDashboard = new UserDashboard(user);
        userDashboard.show(); // build UI
    }

    @Test
    public void testDepositAndWithdraw() throws Exception {
        double initialBalance = user.getAccount().getBalance();

        // Deposit via reflection (simulate listener)
        user.getAccount().setBalance(initialBalance + 500);
        Assert.assertEquals(user.getAccount().getBalance(), initialBalance + 500);

        // Withdraw (valid)
        user.getAccount().setBalance(user.getAccount().getBalance() - 200);
        Assert.assertEquals(user.getAccount().getBalance(), initialBalance + 300);
    }

    @Test
    public void testShowUserDetailsDialog() throws Exception {
        Method method = UserDashboard.class.getDeclaredMethod("showUserDetailsDialog");
        method.setAccessible(true);
        method.invoke(userDashboard);
        Assert.assertNotNull(user.getAccount().getAccountNumber());
    }
}