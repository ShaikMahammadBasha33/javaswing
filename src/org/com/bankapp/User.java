package org.com.bankapp;


public class User {
	 private String name;
	    private String password;
	    private String role;  // Admin or User
	    private Account account; // Only User has an account

	    public User(String name, String password, String role, Account account) {
	        this.name = name;
	        this.password = password;
	        this.role = role;
	        this.account = account;
	    }

	    public String getName() {
	        return name;
	    }

	    public String getPassword() {
	        return password;
	    }

	    public String getRole() {
	        return role;
	    }

	    public Account getAccount() {
	        return account;
	    }

	    public void setAccount(Account account) {
	        this.account = account;
	    }

	    @Override
	    public String toString() {
	        String accountInfo = account != null ? account.toString() : "No Account";
	        return "Name: " + name + ", Role: " + role + ", " + accountInfo;
	    }

}
