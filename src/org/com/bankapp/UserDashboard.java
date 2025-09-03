package org.com.bankapp;

import javax.swing.*;
import java.awt.*;

public class UserDashboard {
	private final User user;
	private Account selectedAccount;

	public UserDashboard(User user) {
		this.user = user;
		if (!user.getAccounts().isEmpty()) {
			this.selectedAccount = user.getAccounts().get(0); // Automatically select the first account
		}
	}

	public void show() {
		JFrame userFrame = new JFrame("User Dashboard");
		userFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		userFrame.setSize(500, 400);

		// Top Panel for Welcome Message
		JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
		JLabel titleLabel = new JLabel("Welcome, " + user.getName());
		titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
		topPanel.add(titleLabel);
		userFrame.add(topPanel, BorderLayout.NORTH);

		// Account Selection Panel
		JLabel accountLabel = new JLabel("Select Account:");
		JComboBox<Account> accountComboBox = new JComboBox<>(user.getAccounts().toArray(new Account[0]));
		accountComboBox.setPreferredSize(new Dimension(350, 45));

		// Update the selected account when a new account is chosen from the dropdown
		accountComboBox.addActionListener(e -> {
			selectedAccount = (Account) accountComboBox.getSelectedItem();
		});

		JPanel accountSelectionPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
		accountSelectionPanel.add(accountLabel);
		accountSelectionPanel.add(accountComboBox);
		userFrame.add(accountSelectionPanel, BorderLayout.NORTH);

		// Main Panel to Display Balance and Amount Input
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		mainPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

		JLabel balanceLabel = new JLabel(
				"Balance: Rs " + (selectedAccount != null ? selectedAccount.getBalance() : "N/A"));
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

		// Deposit Button Action Listener
		depositButton.addActionListener(e -> {
			try {
				double amount = Double.parseDouble(amountField.getText());
				if (amount <= 0) {
					JOptionPane.showMessageDialog(userFrame, "Amount must be greater than zero.", "Error",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
				if (selectedAccount != null) {
					selectedAccount.setBalance(selectedAccount.getBalance() + amount);
					balanceLabel.setText("Balance: Rs " + selectedAccount.getBalance());
					JOptionPane.showMessageDialog(userFrame, "Deposit Successful! Amount Deposited: Rs " + amount);
				} else {
					JOptionPane.showMessageDialog(userFrame, "No account selected.", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(userFrame, "Invalid Amount! Please enter a valid number.", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		});

		// Withdraw Button Action Listener
		withdrawButton.addActionListener(e -> {
			try {
				double amount = Double.parseDouble(amountField.getText());
				if (amount <= 0) {
					JOptionPane.showMessageDialog(userFrame, "Amount must be greater than zero.", "Error",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
				if (selectedAccount != null) {
					if (amount > selectedAccount.getBalance()) {
						JOptionPane.showMessageDialog(userFrame, "Insufficient Balance!", "Error",
								JOptionPane.ERROR_MESSAGE);
					} else {
						selectedAccount.setBalance(selectedAccount.getBalance() - amount);
						balanceLabel.setText("Balance: Rs " + selectedAccount.getBalance());
						JOptionPane.showMessageDialog(userFrame,
								"Withdrawal Successful! Amount Withdrawn: Rs " + amount);
					}
				} else {
					JOptionPane.showMessageDialog(userFrame, "No account selected.", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(userFrame, "Invalid Amount! Please enter a valid number.", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		});

		// Show Details Button Action Listener
		showDetailsButton.addActionListener(e -> showUserDetailsDialog());

		// Logout Button Action Listener
		logoutButton.addActionListener(e -> {
			int confirmLogout = JOptionPane.showConfirmDialog(userFrame, "Are you sure you want to logout?", "Logout",
					JOptionPane.YES_NO_OPTION);
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
		userDetailsDialog.setSize(400, 300);
		userDetailsDialog.setLayout(new BorderLayout());

		// Prepare Details Panel
		JPanel detailsPanel = new JPanel();
		detailsPanel.setLayout(new GridLayout(0, 1, 10, 10)); // Dynamically add rows
		detailsPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		// Display general user info
		detailsPanel.add(new JLabel("Full Name: " + user.getName()));
		detailsPanel.add(new JLabel("Role: " + user.getRole()));

		// Display account details
		for (Account account : user.getAccounts()) {
			detailsPanel.add(new JLabel("-------------------------------"));
			detailsPanel.add(new JLabel("Account Type: " + account.getAccountType()));
			detailsPanel.add(new JLabel("Account Number: " + account.getAccountNumber()));
			detailsPanel.add(new JLabel("Balance: Rs " + account.getBalance()));
		}

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