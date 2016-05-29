package com.library_automation.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.library_automation.classes.User;

@Component("usersDAO")
public class UsersDAO {

	private NamedParameterJdbcTemplate template;
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		template = new NamedParameterJdbcTemplate(dataSource);
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	/*
	 * Creating account
	 * 
	 * This method inserts user's properties to the users and authorities
	 * tables.
	 */

	@Transactional
	public void createUser(User user) {
		System.out.println(user);
		Map<String, Object> params = new HashMap<>();
		params.put("name", user.getName());
		params.put("surname", user.getSurname());
		params.put("email", user.getEmail());
		params.put("username", user.getUsername());
		params.put("password", user.getPassword());
		params.put("authority", user.getAuthority());
		params.put("enabled", user.isEnabled());

		template.update(
				"insert into users (name,surname,email,username,enabled,password) values (:name,:surname,:email,:username,:enabled,:password)",
				params);
		template.update("insert into authorities (username, authority) values (:username, :authority)", params);

	}

	public boolean isAccountExist(User user) {
		boolean result = false;

		/*
		 * If account does not exist already, spring throws
		 * EmptyResultDataAccessException because of returning null value from
		 * the database. So we use try-catch block to solve this problem. If
		 * spring throws exception, it means account does not exist, so we
		 * should create user to the database.
		 */
		try {
			User u = jdbcTemplate.queryForObject("select * from users where email=? or username=?",
					new Object[] { user.getEmail(), user.getUsername() }, new UserMapper());

			// account already exist
			if (u.getId() != 0 || !u.equals(null)) {
				return true;
			}

			// account not exist
			else {
				return false;
			}
		} catch (EmptyResultDataAccessException e) {
			return result;
		}

	}

	/*
	 * we use this method for catch the user, when user logged in
	 * 
	 */

	public User getAuthenticatedUser(String username) {
		
		User authenticatedUser = jdbcTemplate.queryForObject("select * from users where username=?",
				new Object[] { username }, new UserMapper());
		return authenticatedUser;

	}

	/*
	 * This method returns all users for the admin
	 * 
	 */
	public List<User> getAllUsers() {

		List<User> users = template.query("select * from users", new UserMapper());

		return users;
	}

	public boolean updateUser(User user) {
		System.out.println("Guncellenecek kullanicinin id si: "+user.getId());
		user.setAuthority("ROLE_USER");
		SqlParameterSource params = new BeanPropertySqlParameterSource(user);
		template.update("update users set name=:name,surname=:surname,email=:email,username=:username,password=:password where id=:id", params);
		template.update("insert into authorities(username,authority) values(:username,:authority)", params);

		return false;
	}
	
	public void deleteUser(String id){
		
		Map<String,Object> param = new HashMap<>();
		param.put("id", Integer.parseInt(id));
		template.update("delete from debt where user_id=:id", param);
		template.update("delete from users where id=:id", param);
	}
	
	public void editUser(User user){
		SqlParameterSource params = new BeanPropertySqlParameterSource(user);
		template.update("update users set name=:name,surname=:surname,email=:email,username=:username,password=:password where id=:id", params);
	}
	
	public User getUserByUsername(String username){
		
		return jdbcTemplate.queryForObject("select * from users where username=?", new Object[]{username}, new UserMapper());
	}

}
