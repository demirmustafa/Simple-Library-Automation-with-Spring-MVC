package com.library_automation.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

import com.library_automation.classes.Book;

@Component("booksDAO")
public class BooksDAO {
	
	private DataSource dataSource;
	private NamedParameterJdbcTemplate template;
	private JdbcTemplate jdbcTemplate;
	private Connection conn;
	private PreparedStatement ps;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		template = new NamedParameterJdbcTemplate(dataSource);
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public Book getBookById(int id){
		
		return jdbcTemplate.queryForObject("select b.name,a.name,a.surname,p.name,c.name, b.status from book b, author a, publisher p, category c where "
				+ "b.aid=a.id and b.pid=p.id and b.cid=c.id  and id=?", new Object[]{id}, new BookMapper());
	}
	
	public List<Book> getAllBooks(){
		return jdbcTemplate.query("select b.id, b.name,a.name as a_name,a.surname as a_surname, p.name as p_name, c.name as c_name, b.status from book b, author a, publisher p, category c where b.aid=a.id and b.pid=p.id and b.cid=c.id", new BookMapper());
	}
	
	public void deleteBookById(String id){
		Map<String, String> params = new HashMap<>();
		params.put("id", id);
		template.update("delete from book where id=:id",params);
		
	}
	
	public void editBook(Book book){
		
		Map<String, Object> params = new HashMap<>();
		params.put("book_id", book.getId());
		params.put("name", book.getName());
		params.put("author_id", book.getAuthor().getId());
		params.put("publisher_id", book.getPublisher().getId());
		params.put("category_id", book.getCategory().getId());
		template.update("update book set name=:name, aid=:author_id,pid=:publisher_id,cid=:category_id where id=:book_id", params);
	}
	
	public void addNewBook(Book book){
		
		Map<String, Object> params = new HashMap<>();
		
		params.put("name", book.getName());
		params.put("author_id", book.getAuthor().getId());
		params.put("publisher_id", book.getPublisher().getId());
		params.put("category_id", book.getCategory().getId());
		params.put("status", "Available");
		
		template.update("insert into book (name,aid,pid,cid,status) values (:name,:author_id,:publisher_id,:category_id,:status)", params);
	}
	
	
	

}
