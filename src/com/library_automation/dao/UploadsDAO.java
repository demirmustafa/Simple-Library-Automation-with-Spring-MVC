package com.library_automation.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.library_automation.classes.Upload;

@Component
public class UploadsDAO {
	
	private DataSource dataSource;
	private JdbcTemplate template;
	private NamedParameterJdbcTemplate namedTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		template = new JdbcTemplate(dataSource);
		namedTemplate = new NamedParameterJdbcTemplate(dataSource);
	}
	
	
	//this id is user id
	public Upload getMyUploads(int id){
		return template.queryForObject("select t.id, t.name, u.id,u.name as u_name,u.surname as u_surname from thesis t, users u  where t.uid=u.id and t.uid=?", new Object[]{id}, new UploadMapper());
	}
	
	public void saveUpload(Upload upload){
		
		Map<String, Object> params = new HashMap<>();
		params.put("name", upload.getName());
		params.put("uid", upload.getUser().getId());
		params.put("tags", "java");
		
		namedTemplate.update("insert into thesis (name,uid,tags) values (:name,:uid,:tags)", params);
		
	}
	
	public List<Upload> search(String title){
		
		return template.query("select id,name,tags from library.thesis where tags like'%"+title+"%'", new UploadMapper());
	}
	
	

}
