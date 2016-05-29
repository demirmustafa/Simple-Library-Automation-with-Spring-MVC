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

import com.library_automation.classes.Publisher;

@Component
public class PublishersDAO {
	
	private DataSource dataSource;
	private NamedParameterJdbcTemplate template;
	private JdbcTemplate jdbcTemplate;
	
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		template = new NamedParameterJdbcTemplate(dataSource);
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public List<Publisher> getAllPublishers(){
		
		return jdbcTemplate.query("select * from library.publisher", new PublisherMapper());
	}
	
	public void addNewPublisher(Publisher publisher){
		
		SqlParameterSource params = new BeanPropertySqlParameterSource(publisher);
		
		template.update("insert into library.publisher (name) values (:publisher_name)", params);
	}
	
	public void deletePublisher(int id){
		Map<String, Integer> param = new HashMap<>();
		param.put("id", id);
		
		template.update("delete from library.publisher where id=:id", param);
	}

}
