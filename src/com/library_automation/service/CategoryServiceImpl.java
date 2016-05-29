package com.library_automation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library_automation.classes.Category;
import com.library_automation.dao.CategoriesDAO;

@Service
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	private CategoriesDAO categoriesDAO;

	@Override
	public List<Category> getAllCategories() {
		// TODO Auto-generated method stub
		return categoriesDAO.getAllCategories();
	}

	@Override
	public void createCateogry(Category category) {
		// TODO Auto-generated method stub
		
		categoriesDAO.createCategory(category);
		
	}

	@Override
	public void deleteCategory(int id) {
		// TODO Auto-generated method stub
		
		categoriesDAO.deleteCategory(id);
		
	}

}
