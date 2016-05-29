package com.library_automation.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.library_automation.classes.Book;
import com.library_automation.classes.Reservation;

@Component
public class ReservationsDAO {
	
	private DataSource dataSource;
	private JdbcTemplate template;
	private NamedParameterJdbcTemplate namedTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		template = new JdbcTemplate(dataSource);
		namedTemplate = new NamedParameterJdbcTemplate(dataSource);
	}
	
	
	public void reserveBook(Reservation reservation){
		
		Map<String, Integer> params = new HashMap<>();
		params.put("id", reservation.getId());
		params.put("bid", reservation.getBook().getId());
		params.put("uid", reservation.getUser().getId());
		
		namedTemplate.update("insert into reservedbooks (bid,uid) values (:bid,:uid)", params);
		namedTemplate.update("update book set status='CheckedOut' where id=:bid", params);
		
		
	}
	
	public List<Book> getMyActiveReservations(int userId){
		
		return template.query("select b.id,b.name,a.name as a_name, a.surname as a_surname,p.name as p_name, c.name as c_name, b.status from book b,author a,category c,publisher p, reservedbooks r where "
				+ "b.aid=a.id and b.pid=p.id and b.cid=c.id and  r.bid=b.id and r.uid=? and b.status='CheckedOut'", new Object[]{userId}, new BookMapper());
		
		
	}
	
	
	public void restituteBook(Reservation reservation){
		
		Map<String, Object> params = new HashMap<>();
		params.put("bid", reservation.getBook().getId());
		params.put("uid", reservation.getUser().getId());
		
		namedTemplate.update("delete from library.reservedbooks where bid=:bid and uid=:uid", params);
		namedTemplate.update("update book set status='Available' where id=:bid", params);
		namedTemplate.update("delete from reservationdetails where book_id=:bid", params);
		
		
	}

}
