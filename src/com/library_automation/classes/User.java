package com.library_automation.classes;

public class User {

	private int id;
	private String name;
	private String surname;
	private String email;
	private String username;
	private String password;
	private String authority;
	private boolean enabled = false;

	public User() {
	}
	
	public User(int id){
		this.id = id;
	}
	
	public User(int id, String name, String surname){
		this.id = id;
		this.name = name;
		this.surname = surname;
	}

	/*
	 * public User(int id, String name, String surname, String email, String
	 * username, String password, String authority, boolean enabled) { super();
	 * this.id = id; this.name = name; this.surname = surname; this.email =
	 * email; this.username = username; this.password = password; this.authority
	 * = authority; this.enabled = enabled; }
	 */
	public User(String name, String surname, String email, String username, String password) {
		super();
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.username = username;
		this.password = password;
	}

	public User(int id, String name, String surname, String email, String username, String password) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.username = username;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", surname=" + surname + ", email=" + email + ", username="
				+ username + ", password=" + password + ", authority=" + authority + ", enabled=" + enabled + "]";
	}

}
