package com.library_automation.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.library_automation.classes.Upload;
import com.library_automation.classes.User;

public class UploadMapper implements RowMapper<Upload>{

	@Override
	public Upload mapRow(ResultSet res, int arg1) throws SQLException {
		// TODO Auto-generated method stub
		return new Upload(res.getInt("id"),res.getString("name"),res.getString("tags"));
	}

}
