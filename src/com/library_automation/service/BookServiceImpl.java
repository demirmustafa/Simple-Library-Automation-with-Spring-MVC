package com.library_automation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library_automation.classes.Book;
import com.library_automation.dao.BooksDAO;


@Service
public class BookServiceImpl implements BookService{

	
	@Autowired
	private BooksDAO booksDAO;
	
	@Override
	public List<Book> getAllBooks() {
		// TODO Auto-generated method stub
		return booksDAO.getAllBooks();
	}

	@Override
	public void editBook(Book book) {
		// TODO Auto-generated method stub
		
		booksDAO.editBook(book);
		
	}

	@Override
	public void addNewBook(Book book) {
		// TODO Auto-generated method stub
		
		booksDAO.addNewBook(book);
	}

	@Override
	public void deleteBook(int id) {
		// TODO Auto-generated method stub
		
		booksDAO.deleteBookById(String.valueOf(id));
		
	}

	@Override
	public List<Book> getMyBooks(int authUserId) {
		// TODO Auto-generated method stub
		return null;
	}

}
