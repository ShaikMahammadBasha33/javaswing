package org.com.test.bankapp;

import org.testng.Assert;
import org.com.bankapp.Account;
import org.com.bankapp.BankService;
import org.com.bankapp.User;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class BankServiceTest {

    private BankService bankService;

    @BeforeMethod
    public void setup() {
        bankService = new BankService();
    }

    @Test
    public void testGetUsers() {
        List<User> users = bankService.getUsers();
        Assert.assertTrue(users.size() >= 2);
    }

    @Test
    public void testAddUserSuccess() {
        boolean result = bankService.addUser("newUser", "pass", "User", new Account("ACC100", 1000, "Savings"));
        Assert.assertTrue(result);
    }

    @Test
    public void testAddUserFailure_Duplicate() {
        bankService.addUser("duplicate", "pass", "User", null);
        boolean result = bankService.addUser("duplicate", "pass", "User", null);
        Assert.assertFalse(result);
    }

    @Test
    public void testDeleteUserSuccess() {
        bankService.addUser("toDelete", "pass", "User", null);
        boolean deleted = bankService.deleteUser("toDelete");
        Assert.assertTrue(deleted);
    }

    @Test
    public void testDeleteUserFailure() {
        boolean deleted = bankService.deleteUser("ghost");
        Assert.assertFalse(deleted);
    }

 

    @Test
    public void testValidateCredentials() {
        bankService.addUser("check", "mypwd", "User", null);
        User user = bankService.validateCredentials("check", "mypwd");
        Assert.assertNotNull(user);
    }

    @Test
    public void testValidateAdmin() {
        Assert.assertTrue(bankService.validateAdmin("admin", "admin123"));
        Assert.assertFalse(bankService.validateAdmin("user1", "userpass"));
    }

    @Test
    public void testValidateUser() {
        User user = bankService.validateUser("user1", "userpass");
        Assert.assertNotNull(user);
    }

    @Test
    public void testFindUserByName() {
        User user = bankService.findUserByName("user1");
        Assert.assertNotNull(user);
    }


}