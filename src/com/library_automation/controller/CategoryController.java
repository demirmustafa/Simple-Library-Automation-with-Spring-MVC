package com.library_automation.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.library_automation.classes.Category;
import com.library_automation.service.CategoryService;

@Controller
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	
	@RequestMapping("/admin/categories/")
	public String showCategories(ModelMap model){
		
		model.addAttribute("categories", categoryService.getAllCategories());
		
		return "manc";
	}
	
	
	@RequestMapping(value="/admin/deletecategory/",method=RequestMethod.POST)
	public String deleteCategory(ModelMap model, HttpServletRequest req){
		
		categoryService.deleteCategory(Integer.parseInt(req.getParameter("id")));
		model.addAttribute("categories", categoryService.getAllCategories());
		
		return "manc";
	}
	
	@RequestMapping(value="/addnewcategory/",method=RequestMethod.POST)
	public String addNewCategory(ModelMap model, Category category){
		
		categoryService.createCateogry(category);
		
		model.addAttribute("categories", categoryService.getAllCategories());
		
		return "manc";
	}

}
