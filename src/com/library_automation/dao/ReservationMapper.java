package com.library_automation.dao;

import java.awt.print.Book;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.library_automation.classes.Reservation;
import com.library_automation.classes.User;

public class ReservationMapper implements RowMapper<Reservation>{

	@Override
	public Reservation mapRow(ResultSet res, int arg1) throws SQLException {
		// TODO Auto-generated method stub
		return new Reservation(res.getInt("id"),new User(res.getInt("uid")),new com.library_automation.classes.Book(res.getInt("bid")));
	}

}
