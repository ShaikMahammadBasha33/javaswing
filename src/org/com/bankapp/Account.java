package org.com.bankapp;

public class Account {
    private final String accountNumber;
    private double balance;
    private String accountType; // Savings, Current

    public Account(String accountNumber, double balance, String accountType) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.accountType = accountType;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getAccountType() {
        return accountType;
    }

    @Override
    public String toString() {
        return "Acc Number: " + accountNumber + 
               ", Bal: Rs" + String.format("%.2f", balance) + 
               ", Acc Type: " + accountType;
    }
}