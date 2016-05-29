package com.library_automation.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

import com.library_automation.classes.Book;

@Component
public class SearchDAO {

	private DataSource dataSource;
	private JdbcTemplate template;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		template = new JdbcTemplate(dataSource);
	}

	public List<Book> searchByBookName(String title) {

		return template
				.query("select b.id,b.name,a.name as a_name, a.surname as a_surname, p.name as p_name, c.name as c_name, b.status from book b, author a, publisher p, category c where b.aid=a.id and b.pid=p.id and b.cid=c.id and b.name like '%"
						+ title + "%'", new BookMapper());
	}

	public List<Book> searchByAuthorName(String title) {

		return template
				.query("select b.id, b.name, a.name as a_name,a.surname as a_surname, p.name as p_name, c.name as c_name, b.status from book b, author a, publisher p, category c where b.aid=a.id and b.pid=p.id and b.cid=c.id and a.name like '%"
						+ title + "%'", new BookMapper());

	}

	public List<Book> searchByPublisherName(String title) {

		return template
				.query("select b.id,b.name, a.name as a_name, a.surname as a_surname, p.name as p_name, c.name as c_name, b.status from book b, author a, publisher p, category c where b.aid=a.id and b.pid=p.id and b.cid=c.id and p.name like '%"
						+ title + "%'", new BookMapper());

	}

	public List<Book> searchByCategoryName(String title) {

		return template
				.query("select b.id, b.name, a.name as a_name, a.surname as a_surname, p.name as p_name, c.name as c_name, b.status from book b, author a, publisher p, category c where b.aid=a.id and b.pid=p.id and b.cid=c.id and c.name like '%"
						+ title + "%'", new BookMapper());

	}

}
