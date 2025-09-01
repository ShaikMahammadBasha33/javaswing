package org.com.bankapp;

import javax.swing.*;

public class LoginPage {
    private final BankService bankService;

    public LoginPage(BankService bankService) {
        this.bankService = bankService;
    }

    public void show() {
        JFrame loginFrame = new JFrame("Bank Management System");
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginFrame.setSize(400, 300);
        loginFrame.setLayout(null);
        
        JLabel roleLabel = new JLabel("Login As:");
        roleLabel.setBounds(50, 20, 100, 25);
        loginFrame.add(roleLabel);

        JRadioButton adminRadio = new JRadioButton("Admin");
        adminRadio.setFocusable(false);
        adminRadio.setBounds(150, 20, 80, 25);
        JRadioButton userRadio = new JRadioButton("User");
        userRadio.setBounds(230, 20, 80, 25);
        userRadio.setFocusable(false);
        ButtonGroup roleGroup = new ButtonGroup();
        roleGroup.add(adminRadio);
        roleGroup.add(userRadio);

        loginFrame.add(adminRadio);
        loginFrame.add(userRadio);

        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(50, 60, 80, 25);
        loginFrame.add(usernameLabel);

        JTextField usernameField = new JTextField();
        usernameField.setBounds(150, 60, 180, 25);
        loginFrame.add(usernameField);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(50, 100, 80, 25);
        loginFrame.add(passwordLabel);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(150, 100, 180, 25);
        loginFrame.add(passwordField);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(100, 140, 100, 25);
        loginFrame.add(loginButton);

        JButton exitButton = new JButton("Exit");
        exitButton.setBounds(210, 140, 100, 25);
        loginFrame.add(exitButton);

        // Handle Login Action
        loginButton.addActionListener(e -> {
            String username = usernameField.getText().trim();
            String password = new String(passwordField.getPassword());
            if (adminRadio.isSelected() && bankService.validateAdmin(username, password)) {
                loginFrame.dispose();
                new AdminDashboard(bankService).show();
            } else if (userRadio.isSelected()) {
                User user = bankService.validateUser(username, password);
                if (user != null) {
                    loginFrame.dispose();
                    new UserDashboard(user).show();
                } else {
                    JOptionPane.showMessageDialog(loginFrame, "Invalid User Credentials!", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(loginFrame, "Invalid Credentials or Role!", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        });

        // Exit Button Action
        exitButton.addActionListener(e -> System.exit(0));

        loginFrame.setVisible(true);
    }
}