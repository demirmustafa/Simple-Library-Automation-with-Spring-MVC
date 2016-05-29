package com.library_automation.service;

import java.util.List;

import com.library_automation.classes.Category;

public interface CategoryService {
	
	public List<Category> getAllCategories();
	
	public void createCateogry(Category category);
	public void deleteCategory(int id);

}
