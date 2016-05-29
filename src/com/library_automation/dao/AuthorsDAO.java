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

import com.library_automation.classes.Author;
import com.library_automation.classes.Category;


@Component("authorsDAO")
public class AuthorsDAO {
	
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate template;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		template =  new NamedParameterJdbcTemplate(dataSource);
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public List<Author> getAllAuthors(){
		
			return jdbcTemplate.query("SELECT id,name,surname from library.author", new AuthorMapper());
		 
	}
	
	public void createAuthor(Author author){
		
		SqlParameterSource params = new BeanPropertySqlParameterSource(author);
		template.update("insert into library.author (name,surname) values (:name,:surname)", params);
		
	}
	
	public void deleteAuthor(int id){
		Map<String, Integer> param = new HashMap<>();
		param.put("id", id);
		template.update("delete from author where id=:id", param);
		
	}
	
	

}
