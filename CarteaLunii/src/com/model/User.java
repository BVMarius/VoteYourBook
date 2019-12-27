package com.model;

public class User {
	
	private String firstName;
	private String lastName;
	private String password;
	private String email;
	private int userId;
	
	public static User createInstance(String firstName, String lastName, String password, String email){
		User u = new User();
		u.firstName = firstName;
		u.lastName = lastName;
		u.password = password;
		u.email = email;
		return u;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}


}
