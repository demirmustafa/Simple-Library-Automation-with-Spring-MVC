package com.library_automation.service;

import java.util.List;

import com.library_automation.classes.Author;

public interface AuthorService {
	
	public List<Author> getAllAuthors();
	
	public void createAuthor(Author author);
	
	public void deleteAuthor(int id);

}
