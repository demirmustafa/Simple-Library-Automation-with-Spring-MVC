package com.library_automation.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.library_automation.classes.Author;

public class AuthorMapper implements RowMapper<Author>{

	@Override
	public Author mapRow(ResultSet res, int arg1) throws SQLException {
		// TODO Auto-generated method stub
		return new Author(res.getInt("id"), res.getString("name"), res.getString("surname"));
	}

}
