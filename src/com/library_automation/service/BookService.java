package com.library_automation.service;

import java.util.List;

import com.library_automation.classes.Book;

public interface BookService {
	
	public List<Book> getAllBooks();
	
	public void editBook(Book book);
	
	public void addNewBook(Book book);
	
	public void deleteBook(int id);
	
	public List<Book> getMyBooks(int authUserId);

}
