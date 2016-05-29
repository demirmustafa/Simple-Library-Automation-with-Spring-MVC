package com.library_automation.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.library_automation.classes.Publisher;

public class PublisherMapper implements RowMapper<Publisher>{

	@Override
	public Publisher mapRow(ResultSet res, int arg1) throws SQLException {
		// TODO Auto-generated method stub
		return new Publisher(res.getInt("id"), res.getString("name"));
		
	}

}
