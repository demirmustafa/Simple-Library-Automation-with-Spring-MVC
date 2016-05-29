package com.library_automation.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.library_automation.classes.Author;
import com.library_automation.classes.Book;
import com.library_automation.classes.Category;
import com.library_automation.classes.Publisher;
import com.library_automation.dao.AuthorsDAO;
import com.library_automation.dao.BooksDAO;
import com.library_automation.dao.PublishersDAO;
import com.library_automation.service.BookService;
import com.library_automation.service.CategoryService;

@Controller
public class BookController {

	@Autowired
	private BooksDAO booksDAO;

	@Autowired
	private AuthorsDAO authorsDAO;

	@Autowired
	private PublishersDAO publishersDAO;

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private BookService bookService;

	@RequestMapping("/admin/books/")
	public String showAllBooks(ModelMap model) {
		model.addAttribute("books", bookService.getAllBooks());
		// Book book = booksDAO.getAllBooks().get(0);
		// System.out.println(book);

		model.addAttribute("authors", authorsDAO.getAllAuthors());
		model.addAttribute("publishers", publishersDAO.getAllPublishers());
		model.addAttribute("categories", categoryService.getAllCategories());
		return "manb";
	}

	@RequestMapping("/admin/editbook/")
	public String editBook(ModelMap model, HttpServletRequest request) {

		
		model.addAttribute("authors", authorsDAO.getAllAuthors());
		model.addAttribute("publishers", publishersDAO.getAllPublishers());
		model.addAttribute("categories", categoryService.getAllCategories());
		
		model.addAttribute("books", bookService.getAllBooks());
		return "manb";
	}

	@RequestMapping("/admin/deletebook/")
	public String deleteBook(ModelMap model, HttpServletRequest request) {
		model.addAttribute("authors", authorsDAO.getAllAuthors());
		model.addAttribute("publishers", publishersDAO.getAllPublishers());
		model.addAttribute("categories", categoryService.getAllCategories());
		bookService.deleteBook(Integer.parseInt(request.getParameter("id")));
		model.addAttribute("books", booksDAO.getAllBooks());
		return "manb";
	}

	@RequestMapping(value = "/addnewbook", method = RequestMethod.POST)
	public String addNewBook(ModelMap model, HttpServletRequest req) {
		
		
		Author author = new Author(Integer.parseInt(req.getParameter("author")));
		Publisher publisher = new Publisher(Integer.parseInt(req.getParameter("publisher")));
		Category category = new Category(Integer.parseInt(req.getParameter("category")));

		bookService.addNewBook(new Book(req.getParameter("book_name"),author,publisher,category));
		
		model.addAttribute("books", booksDAO.getAllBooks());
		model.addAttribute("authors", authorsDAO.getAllAuthors());
		model.addAttribute("publishers", publishersDAO.getAllPublishers());
		model.addAttribute("categories", categoryService.getAllCategories());

		return "manb";
	}
	
	
	
}
