package com.library_automation.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.library_automation.classes.Author;
import com.library_automation.service.AuthorService;

@Controller
public class AuthorController {
	
	@Autowired
	private AuthorService authorService;
	
	
	@RequestMapping("/admin/authors/")
	public String showAuthors(ModelMap model){
		
		model.addAttribute("authors", authorService.getAllAuthors());
		
		return "mana";
	}
	
	
	@RequestMapping(value="/admin/deleteauthor/",method=RequestMethod.POST)
	public String deleteAuthor(ModelMap model, HttpServletRequest req){
		authorService.deleteAuthor(Integer.parseInt(req.getParameter("id")));
		model.addAttribute("authors", authorService.getAllAuthors());
		return "mana";
	}
	
	
	@RequestMapping(value="/addnewauthor/",method=RequestMethod.POST)
	public String addNewAuthor(ModelMap model, Author author){
		
		authorService.createAuthor(author);
		model.addAttribute("authors", authorService.getAllAuthors());
		
		return "mana";
	}

}
