package org.com.bankapp;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.awt.*;

public class AdminDashboard {
	private final BankService bankService;
	private final JFrame adminFrame;
	private JTable userTable;
	private DefaultTableModel tableModel;

	public AdminDashboard(BankService bankService) {
		this.bankService = bankService;
		this.adminFrame = new JFrame("Admin Dashboard");
	}

	public void show() {
		adminFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		adminFrame.setSize(1000, 600);

		// Title Label
		JLabel titleLabel = new JLabel("Admin Dashboard - Manage Users and Accounts", JLabel.CENTER);
		titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
		adminFrame.add(titleLabel, BorderLayout.NORTH);

		// Create and populate JTree
		DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode("Accounts");
		DefaultMutableTreeNode savingsNode = new DefaultMutableTreeNode("Savings");
		DefaultMutableTreeNode currentNode = new DefaultMutableTreeNode("Current");
		rootNode.add(savingsNode);
		rootNode.add(currentNode);

		JTree accountTree = new JTree(new DefaultTreeModel(rootNode));
		accountTree.setRootVisible(true);

		accountTree.addTreeSelectionListener(e -> {
			DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) accountTree.getLastSelectedPathComponent();
			if (selectedNode == null)
				return;

			String selectedType = selectedNode.toString();
			if (selectedType.equals("Savings")) {
				filterByAccountType("Savings");
			} else if (selectedType.equals("Current")) {
				filterByAccountType("Current");
			} else {
				refreshTable();
			}
		});

		// Create user table
		String[] columnNames = { "Name", "Role", "Account Number", "Balance", "Account Type" };
		tableModel = new DefaultTableModel(columnNames, 0);
		userTable = new JTable(tableModel);
		refreshTable();

		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, new JScrollPane(accountTree),
				new JScrollPane(userTable));
		splitPane.setDividerLocation(200);

		adminFrame.add(splitPane, BorderLayout.CENTER);

		// Add Buttons Panel With Icons
		JPanel buttonPanel = new JPanel();

		// Add User Button Icon
		JButton addUserButton = createIconButton("resources/icons/add-user.png", "Add User");
		addUserButton.addActionListener(e -> showAddUserForm());
		buttonPanel.add(addUserButton);

		// Delete User Button Icon
		JButton deleteUserButton = createIconButton("resources/icons/delete-user.png", "Delete User");
		deleteUserButton.addActionListener(e -> deleteSelectedUser());
		buttonPanel.add(deleteUserButton);

		// Logout Button Icon
		JButton logoutButton = createIconButton("resources/icons/logout-rounded-left.png", "Logout");
		logoutButton.addActionListener(e -> {
			adminFrame.dispose();
			new LoginPage(bankService).show(); // Navigate to login page
		});
		buttonPanel.add(logoutButton);

		// Exit Button Icon
		JButton exitButton = createIconButton("resources/icons/close-window.png", "Exit");
		exitButton.addActionListener(e -> System.exit(0));
		buttonPanel.add(exitButton);

		adminFrame.add(buttonPanel, BorderLayout.SOUTH);

		// Add Menu Bar
		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		JMenu helpMenu = new JMenu("Help");

		JMenuItem logoutMenuItem = new JMenuItem("Logout");
		JMenuItem exitMenuItem = new JMenuItem("Exit");
		fileMenu.add(logoutMenuItem);
		fileMenu.add(exitMenuItem);

		JMenuItem aboutMenuItem = new JMenuItem("About");
		helpMenu.add(aboutMenuItem);

		logoutMenuItem.addActionListener(e -> logoutButton.doClick());
		exitMenuItem.addActionListener(e -> exitButton.doClick());
		aboutMenuItem.addActionListener(e -> JOptionPane.showMessageDialog(adminFrame, "Bank Management System v1.0",
				"About", JOptionPane.INFORMATION_MESSAGE));

		menuBar.add(fileMenu);
		menuBar.add(helpMenu);

		adminFrame.setJMenuBar(menuBar);

		adminFrame.setVisible(true);
	}

	public void refreshTable() {
		tableModel.setRowCount(0); // Clear table
		for (User user : bankService.getUsers()) {
			if (user.getAccount() != null) {
				tableModel.addRow(new Object[] {
					user.getName(),
					user.getRole(),
					user.getAccount().getAccountNumber(),
					user.getAccount().getBalance(),
					user.getAccount().getAccountType()
				});
			} else {
				tableModel.addRow(new Object[] {
					user.getName(),
					user.getRole(),
					"N/A", "N/A", "N/A"
				});
			}
		}
	}

	public void filterByAccountType(String accountType) {
		tableModel.setRowCount(0); // Clear table
		for (User user : bankService.getUsers()) {
			if (user.getAccount() != null &&
				user.getAccount().getAccountType().equalsIgnoreCase(accountType)) {
				tableModel.addRow(new Object[] {
					user.getName(),
					user.getRole(),
					user.getAccount().getAccountNumber(),
					user.getAccount().getBalance(),
					user.getAccount().getAccountType()
				});
			}
		}
	}

	public void showAddUserForm() {
	    JDialog addUserDialog = new JDialog(adminFrame, "Add New User", true);
	    addUserDialog.setSize(400, 400);
	    addUserDialog.setLayout(null);

	    // Username label and text field
	    JLabel nameLabel = new JLabel("Username:");
	    nameLabel.setBounds(50, 30, 100, 25);
	    addUserDialog.add(nameLabel);

	    JTextField nameField = new JTextField();
	    nameField.setBounds(200, 30, 150, 25);
	    addUserDialog.add(nameField);

	    // Password label and password field
	    JLabel passwordLabel = new JLabel("Password:");
	    passwordLabel.setBounds(50, 70, 100, 25);
	    addUserDialog.add(passwordLabel);

	    JPasswordField passwordField = new JPasswordField();
	    passwordField.setBounds(200, 70, 150, 25);
	    addUserDialog.add(passwordField);

	    // Role label and combo box
	    JLabel roleLabel = new JLabel("Role (Admin/User):");
	    roleLabel.setBounds(50, 110, 150, 25);
	    addUserDialog.add(roleLabel);

	    JComboBox<String> roleComboBox = new JComboBox<>(new String[] { "User", "Admin" });
	    roleComboBox.setBounds(200, 110, 150, 25);
	    addUserDialog.add(roleComboBox);

	    // Account Number label and text field
	    JLabel accountNumberLabel = new JLabel("Account Number:");
	    accountNumberLabel.setBounds(50, 150, 150, 25);
	    addUserDialog.add(accountNumberLabel);

	    JTextField accountNumberField = new JTextField();
	    accountNumberField.setBounds(200, 150, 150, 25);
	    addUserDialog.add(accountNumberField);

	    // Balance label and text field
	    JLabel balanceLabel = new JLabel("Balance:");
	    balanceLabel.setBounds(50, 190, 150, 25);
	    addUserDialog.add(balanceLabel);

	    JTextField balanceField = new JTextField();
	    balanceField.setBounds(200, 190, 150, 25);
	    addUserDialog.add(balanceField);

	    // Account Type label and combo box
	    JLabel accountTypeLabel = new JLabel("Account Type (Savings/Current):");
	    accountTypeLabel.setBounds(50, 230, 150, 25);
	    addUserDialog.add(accountTypeLabel);

	    JComboBox<String> accountTypeComboBox = new JComboBox<>(new String[] { "Savings", "Current" });
	    accountTypeComboBox.setBounds(200, 230, 150, 25);
	    addUserDialog.add(accountTypeComboBox);

	    // Save button
	    JButton saveButton = new JButton("Save");
	    saveButton.setBounds(100, 300, 100, 25);
	    addUserDialog.add(saveButton);

	    // Cancel button
	    JButton cancelButton = new JButton("Cancel");
	    cancelButton.setBounds(210, 300, 100, 25);
	    addUserDialog.add(cancelButton);

	    // Action Listener for Save Button
	    saveButton.addActionListener(e -> {
	        // Form validation
	        if (nameField.getText().trim().isEmpty() ||
	            passwordField.getPassword().length == 0 ||
	            roleComboBox.getSelectedItem() == null ||
	            accountNumberField.getText().trim().isEmpty() ||
	            balanceField.getText().trim().isEmpty() ||
	            accountTypeComboBox.getSelectedItem() == null) {
	            JOptionPane.showMessageDialog(addUserDialog, "All fields are required.", "Error", JOptionPane.ERROR_MESSAGE);
	            return; // Stop further execution
	        }

	        try {
	            // Validate and gather inputs
	            String username = nameField.getText().trim();
	            String password = new String(passwordField.getPassword());
	            String role = roleComboBox.getSelectedItem().toString();
	            String accountNumber = accountNumberField.getText().trim();
	            double balance = Double.parseDouble(balanceField.getText().trim());
	            String accountType = accountTypeComboBox.getSelectedItem().toString();

	            // Add user to the BankService and refresh the table
	            bankService.addUser(username, password, role, new Account(accountNumber, balance, accountType));
	            refreshTable();
	            JOptionPane.showMessageDialog(addUserDialog, "User added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
	            addUserDialog.dispose();

	        } catch (NumberFormatException ex) {
	            JOptionPane.showMessageDialog(addUserDialog, "Invalid Balance. Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
	        }
	    });

	    // Action Listener for Cancel Button
	    cancelButton.addActionListener(e -> addUserDialog.dispose());

	    addUserDialog.setLocationRelativeTo(adminFrame);
	    addUserDialog.setVisible(true);
	}
	public void deleteSelectedUser() {
		int selectedRow = userTable.getSelectedRow();
		if (selectedRow >= 0) {
			String username = (String) tableModel.getValueAt(selectedRow, 0);
			bankService.deleteUser(username);
			tableModel.removeRow(selectedRow);
			JOptionPane.showMessageDialog(adminFrame, "User deleted successfully!");
		} else {
			JOptionPane.showMessageDialog(adminFrame, "Please select a user to delete!", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public JButton createIconButton(String iconPath, String tooltip) {
		try {
			ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource(iconPath)); // Load icon
			JButton button = new JButton(icon);
			button.setToolTipText(tooltip);
			return button;
		} catch (Exception e) {
			System.err.println("Failed to load icon: " + iconPath);
			e.printStackTrace(); // Print full error
			JButton button = new JButton(tooltip); // Fallback to text if icon fails
			return button;
		}
	}
}