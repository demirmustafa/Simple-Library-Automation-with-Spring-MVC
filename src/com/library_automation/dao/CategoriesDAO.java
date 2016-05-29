package com.library_automation.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

import com.library_automation.classes.Category;

@Component
public class CategoriesDAO {
	
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate template;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		template = new NamedParameterJdbcTemplate(dataSource);
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public List<Category> getAllCategories(){
		
		return jdbcTemplate.query("select * from library.category", new CategoryMapper());
	}
	
	public void deleteCategory(int id){
		Map<String, Integer> param = new HashMap<>();
		param.put("id", id);
		
		template.update("delete from library.category where id=:id", param);
	}
	
	public void createCategory(Category category){
		SqlParameterSource params = new BeanPropertySqlParameterSource(category);
		
		template.update("insert into library.category (name) values (:category_name)", params);
	}

}
