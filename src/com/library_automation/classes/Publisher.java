package com.library_automation.classes;

public class Publisher {

	private int id;
	private String publisher_name;

	public Publisher() {
	}
	
	public Publisher(int id){
		this.id = id;
	}

	public Publisher(String publisher_name) {
		super();
		this.publisher_name = publisher_name;
	}

	public Publisher(int id, String publisher_name) {
		super();
		this.id = id;
		this.publisher_name = publisher_name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPublisher_name() {
		return publisher_name;
	}

	public void setPublisher_name(String publisher_name) {
		this.publisher_name = publisher_name;
	}

	@Override
	public String toString() {
		return "Publisher [id=" + id + ", publisher_name=" + publisher_name + "]";
	}
	
	

}
