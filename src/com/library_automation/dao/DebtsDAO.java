package com.library_automation.dao;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.library_automation.classes.Debt;

@Component
public class DebtsDAO {
	
	private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate template; 
	
	@Autowired
	public void setDataSource(DataSource dataSource){
		jdbcTemplate = new JdbcTemplate(dataSource);
		template = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public Debt getMyTotalDebt(int userId){
		
		return jdbcTemplate.queryForObject("select * from library.debt where user_id=?", new Object[]{userId}, new DebtMapper());
				
		
	}
	
	public void setMyTotalDebt(int userId,double debt){
		
		Map<String, Object> params = new HashMap<>();
		params.put("userId", userId);
		params.put("debt", debt);
		
		template.update("update debt set total_debt=:debt where user_id=:userId", params);
		
	}
	
	public void createDebt(int userId){
		Map<String, Object> param = new HashMap<>();
		param.put("userId", userId);
		param.put("debt", 0.00);
		
		template.update("insert into debt (user_id,total_debt) values (:userId,:debt) ", param);
	}
	
	 

}
