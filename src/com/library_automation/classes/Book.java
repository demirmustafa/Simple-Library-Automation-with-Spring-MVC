package com.library_automation.classes;

import java.util.Date;

public class Book {

	private int id;
	private String name;
	private Author author;
	private Publisher publisher;
	private Category category;
	private String status;
	

	public Book() {

	}

	public Book(int id) {
		this.id = id;
	}

	public Book(String name, Author author, Publisher publisher, Category category) {
		super();
		this.name = name;
		this.author = author;
		this.publisher = publisher;
		this.category = category;
	}

	public Book(int id, String name, Author author, Publisher publisher, Category category) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
		this.publisher = publisher;
		this.category = category;
	}

	public Book(int id, String name, Author author, Publisher publisher, Category category, String status) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
		this.publisher = publisher;
		this.category = category;
		this.status = status;
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

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", author=" + author + ", publisher=" + publisher + ", category="
				+ category + "]";
	}

}
