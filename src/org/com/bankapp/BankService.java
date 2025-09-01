package org.com.bankapp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BankService {
    private final List<User> users = Collections.synchronizedList(new ArrayList<>());

    public BankService() {
        // Predefined users
        users.add(new User("admin", "admin123", "Admin", null));
        users.add(new User("user1", "userpass", "User", new Account("ACC001", 500.0, "Savings")));
        users.add(new User("user2", "userpass", "User", new Account("ACC002", 1000.0, "Current")));
    }

    // Get all users
    public List<User> getUsers() {
        return new ArrayList<>(users); // Return a copy to protect the original list
    }

    // Add a new user
    public boolean addUser(String name, String password, String role, Account account) {
        if (findUserByName(name) != null) {
            return false; // User with the same name already exists
        }
        users.add(new User(name, password, role, account));
        return true; // User added successfully
    }

    // Delete a user by name
    public boolean deleteUser(String name) {
        User user = findUserByName(name);
        if (user == null) {
            return false; // User does not exist
        }
        return users.remove(user);
    }

    // Validate login credentials
    public User validateCredentials(String name, String password) {
        return users.stream()
                .filter(user -> user.getName().equalsIgnoreCase(name) &&
                                user.getPassword().equals(password))
                .findFirst()
                .orElse(null);
    }

    public boolean validateAdmin(String name, String password) {
        User user = validateCredentials(name, password);
        return user != null && user.getRole().equalsIgnoreCase("Admin");
    }

    public User validateUser(String name, String password) {
        User user = validateCredentials(name, password);
        return user != null && user.getRole().equalsIgnoreCase("User") ? user : null;
    }

    // Find a user by their name (case insensitive)
    public User findUserByName(String name) {
        return users.stream()
                .filter(user -> user.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }

}