package com.library_automation.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.library_automation.classes.Author;
import com.library_automation.classes.Book;
import com.library_automation.classes.Category;
import com.library_automation.classes.Publisher;

public class BookMapper implements RowMapper<Book>{

	@Override
	public Book mapRow(ResultSet res, int arg1) throws SQLException {
		// TODO Auto-generated method stub
		
		return new Book(res.getInt("id"), res.getString("name"), new Author(res.getString("a_name"),res.getString("a_surname")), new Publisher(res.getString("p_name")), new Category(res.getString("c_name")),res.getString("status"));
	}

}
