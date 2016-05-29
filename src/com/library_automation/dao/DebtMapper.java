package com.library_automation.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.library_automation.classes.Debt;
import com.library_automation.classes.User;

public class DebtMapper implements RowMapper<Debt>{

	@Override
	public Debt mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		return new Debt(rs.getInt("id"), new User(rs.getInt("user_id")),rs.getDouble("total_debt"));
	}

}
