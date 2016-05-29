package com.library_automation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library_automation.classes.Author;
import com.library_automation.dao.AuthorsDAO;


@Service
public class AuthorServiceImpl implements AuthorService {
	
	@Autowired
	private AuthorsDAO authorsDAO;

	@Override
	public List<Author> getAllAuthors() {
		// TODO Auto-generated method stub
		return authorsDAO.getAllAuthors();
	}

	@Override
	public void createAuthor(Author author) {
		// TODO Auto-generated method stub
		
		authorsDAO.createAuthor(author);

	}

	@Override
	public void deleteAuthor(int id) {
		// TODO Auto-generated method stub
		
		authorsDAO.deleteAuthor(id);

	}

}
