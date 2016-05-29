package com.library_automation.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.library_automation.classes.Category;

public class CategoryMapper implements RowMapper<Category>{

	@Override
	public Category mapRow(ResultSet res, int arg1) throws SQLException {
		// TODO Auto-generated method stub
		return new Category(res.getInt("id"), res.getString("name"));
	}

}
