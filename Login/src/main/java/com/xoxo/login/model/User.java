package com.xoxo.login.model;

public class User {
	
	private String email;
	private String password;
	
	
	public User() {
		
	}
	
	public User(String username, String password) {
		super();
		this.email = username;
		this.password = password;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
		
}


