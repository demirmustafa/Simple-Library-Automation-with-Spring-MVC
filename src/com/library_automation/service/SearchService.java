package com.library_automation.service;

import java.util.List;

import com.library_automation.classes.Book;

public interface SearchService {
	
	public List<Book> searchByBookName(String title);
	
	public List<Book> searchByAuthor(String title);
	
	public List<Book> searchByPublisher(String title);
	
	public List<Book> searchByCategory(String title);
	
	
	public List<Book> getSearchResult(String title);

}
