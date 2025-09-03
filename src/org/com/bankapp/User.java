package org.com.bankapp;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String name; 
    private String password; 
    private String role;
    private List<Account> accounts;

    // Constructor for creating a user without accounts initially
    public User(String name, String password, String role) {
        this.name = name;
        this.password = password;
        this.role = role;
        this.accounts = new ArrayList<>(); 
    }

    // Constructor for creating a user and adding the first account
    public User(String name, String password, String role, Account account) {
        this(name, password, role); // Invoke the above constructor
        if (account != null) {
            this.accounts.add(account); // Add the initial account to the list
        }
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public List<Account> getAccounts() {
        return accounts; // Return the list of accounts
    }

    // Add a new account to the user's list of accounts
    public void addAccount(Account account) {
        if (account != null) {
            accounts.add(account); // Add account to the list
        }
    }

    // Check if the user already has an account of a certain type
    public boolean hasAccountType(String accountType) {
        return accounts.stream()
                .anyMatch(account -> account.getAccountType().equalsIgnoreCase(accountType));
    }

    // Find and return an account by its type (e.g., Savings or Current)
    public Account findAccountByType(String accountType) {
        return accounts.stream()
                .filter(account -> account.getAccountType().equalsIgnoreCase(accountType))
                .findFirst()
                .orElse(null); // Return null if no matching account is found
    }

 
}