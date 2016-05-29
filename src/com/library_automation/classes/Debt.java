package com.library_automation.classes;

public class Debt {

	private int id;
	private User user;
	private double total_debt;

	public Debt(int id, User user, double total_debt) {
		super();
		this.id = id;
		this.user = user;
		this.total_debt = total_debt;
	}

	public Debt(User user, double total_debt) {
		super();
		this.user = user;
		this.total_debt = total_debt;
	}

	public Debt() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public double getTotal_debt() {
		return total_debt;
	}

	public void setTotal_debt(double total_debt) {
		this.total_debt = total_debt;
	}

}
