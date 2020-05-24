package com.capgemini.entities;

public class User {

	private String username;
	private String pass;
	private String phone;

	public User() {
		super();
	}

	public User(String username, String pass, String phone) {
		super();
		this.username = username;
		this.pass = pass;
		this.phone = phone;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	
}
