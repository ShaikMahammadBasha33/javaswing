package org.com.bankapp;

import javax.swing.*;

public class BankApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            BankService bankService = new BankService();
            new LoginPage(bankService).show();
        });
    }
}