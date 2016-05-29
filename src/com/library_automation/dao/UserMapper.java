package com.library_automation.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.library_automation.classes.User;

public class UserMapper implements RowMapper<User>{

	@Override
	public User mapRow(ResultSet rs, int arg1) throws SQLException {
		// TODO Auto-generated method stub
		return new User(rs.getInt("id"),rs.getString("name"),rs.getString("surname"),rs.getString("email"),rs.getString("username"),rs.getString("password"));
	}

}
