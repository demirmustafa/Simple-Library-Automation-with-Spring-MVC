package com.library_automation.classes;

public class Author {

	private int id;
	private String name;
	private String surname;
	
	public Author(){
		
	}

	public Author(int id) {
		this.id = id;
	}

	public Author(String name, String surname) {
		super();
		this.name = name;
		this.surname = surname;
	}

	public Author(int id, String name, String surname) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
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

	@Override
	public String toString() {
		return "Author [id=" + id + ", name=" + name + ", surname=" + surname + "]";
	}
	
	

}
