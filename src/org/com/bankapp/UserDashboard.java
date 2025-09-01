package org.com.bankapp;

import javax.swing.*;
import java.awt.*;

public class UserDashboard {
    private final User user;

    public UserDashboard(User user) {
        this.user = user;
    }

    public void show() {
        JFrame userFrame = new JFrame("User Dashboard");
        userFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        userFrame.setSize(500, 350);

        // Top Panel for Welcome Message
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
        JLabel titleLabel = new JLabel("Welcome, " + user.getName());
        JLabel accountNumber = new JLabel(" | Account No: " + user.getAccount().getAccountNumber() 
                + " | Account Type: " + user.getAccount().getAccountType());
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        accountNumber.setFont(new Font("Arial", Font.BOLD, 16));

        topPanel.add(titleLabel);
        topPanel.add(accountNumber);
        userFrame.add(topPanel, BorderLayout.NORTH);

        // Main Panel to Display Balance and Amount Input
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JLabel balanceLabel = new JLabel("Balance: Rs " + user.getAccount().getBalance());
        balanceLabel.setFont(new Font("Arial", Font.BOLD, 16));
        balanceLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(balanceLabel);

        // Add Spacing
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        // Input Amount Panel
        JPanel amountPanel = new JPanel();
        amountPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 0));
        JLabel amountLabel = new JLabel("Enter Amount:");
        JTextField amountField = new JTextField(10);
        amountField.setPreferredSize(new Dimension(120, 25));
        amountPanel.add(amountLabel);
        amountPanel.add(amountField);
        mainPanel.add(amountPanel);

        // Add Spacing
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        // Button Panel for Deposit, Withdraw, Show Details, and Logout
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 0));
        JButton depositButton = new JButton("Deposit");
        JButton withdrawButton = new JButton("Withdraw");
        JButton showDetailsButton = new JButton("Show Details");
        JButton logoutButton = new JButton("Logout");

        buttonPanel.add(depositButton);
        buttonPanel.add(withdrawButton);
        buttonPanel.add(showDetailsButton);
        buttonPanel.add(logoutButton);
        mainPanel.add(buttonPanel);

        userFrame.add(mainPanel, BorderLayout.CENTER);

        // Add Button Actions
        depositButton.addActionListener(e -> {
            try {
                double amount = Double.parseDouble(amountField.getText());
                user.getAccount().setBalance(user.getAccount().getBalance() + amount);
                balanceLabel.setText("Balance: Rs " + user.getAccount().getBalance());
                JOptionPane.showMessageDialog(userFrame, "Deposit Successful!");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(userFrame, "Invalid Amount!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        withdrawButton.addActionListener(e -> {
            try {
                double amount = Double.parseDouble(amountField.getText());
                if (amount > user.getAccount().getBalance()) {
                    JOptionPane.showMessageDialog(userFrame, "Insufficient Balance!", "Error",
                            JOptionPane.ERROR_MESSAGE);
                } else {
                    user.getAccount().setBalance(user.getAccount().getBalance() - amount);
                    balanceLabel.setText("Balance: Rs " + user.getAccount().getBalance());
                    JOptionPane.showMessageDialog(userFrame, "Withdrawal Successful!");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(userFrame, "Invalid Amount!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        showDetailsButton.addActionListener(e -> showUserDetailsDialog());

        logoutButton.addActionListener(e -> {
            int confirmLogout = JOptionPane.showConfirmDialog(userFrame, "Are you sure you want to logout?", "Logout", JOptionPane.YES_NO_OPTION);
            if (confirmLogout == JOptionPane.YES_OPTION) {
                userFrame.dispose();
                new LoginPage(new BankService()).show(); // Navigate back to the login page
            }
        });

        userFrame.setVisible(true);
    }

 
    private void showUserDetailsDialog() {
        // Dialog for displaying user details
        JDialog userDetailsDialog = new JDialog((JFrame) null, "User Details", true);
        userDetailsDialog.setSize(350, 200);
        userDetailsDialog.setLayout(new BorderLayout());

        // Prepare Details Panel
        JPanel detailsPanel = new JPanel();
        detailsPanel.setLayout(new GridLayout(4, 2, 10, 10)); // Label-Value pairs in a grid
        detailsPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        detailsPanel.add(new JLabel("Full Name:"));
        detailsPanel.add(new JLabel(user.getName()));

        detailsPanel.add(new JLabel("Account Number:"));
        detailsPanel.add(new JLabel(user.getAccount().getAccountNumber()));

        detailsPanel.add(new JLabel("Account Type:"));
        detailsPanel.add(new JLabel(user.getAccount().getAccountType()));

        detailsPanel.add(new JLabel("Balance:"));
        detailsPanel.add(new JLabel("Rs " + user.getAccount().getBalance()));

        userDetailsDialog.add(detailsPanel, BorderLayout.CENTER);

        // Add Close Button
        JButton closeButton = new JButton("Close");
        closeButton.addActionListener(e -> userDetailsDialog.dispose());
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(closeButton);
        userDetailsDialog.add(buttonPanel, BorderLayout.SOUTH);

        userDetailsDialog.setLocationRelativeTo(null);
        userDetailsDialog.setVisible(true);
    }
}