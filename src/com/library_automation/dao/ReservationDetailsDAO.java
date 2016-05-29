package com.library_automation.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.library_automation.classes.ReservationDetails;
import com.library_automation.classes.User;

@Component("rdDAO")
public class ReservationDetailsDAO {
	
	private DataSource dataSource;
	private JdbcTemplate template;
	private NamedParameterJdbcTemplate namedTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		template = new JdbcTemplate(dataSource);
		namedTemplate = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public void setDates(int uid,int bid,String reservationDate, String restituteDate){
		System.out.println("user id: "+uid);
		System.out.println("book id: "+bid);
		System.out.println("reservation date: "+reservationDate);
		System.out.println("restitute date: "+restituteDate);
		
		Map<String, Object> params = new HashMap<>();
		params.put("uid", uid);
		params.put("bid", bid);
		params.put("reservDate", reservationDate);
		params.put("restDate", restituteDate);
		
		
		namedTemplate.update("insert into library.reservationdetails (user_id,book_id,reservation_date, restitute_date) values(:uid,:bid,:reservDate,:restDate) ", params);
		
	}
	
	public List<ReservationDetails> getMyReservations(User user){
		
		System.out.println("metod calisti");
		
		String query = "select b.id, b.name, a.name as a_name, a.surname as a_surname, p.name as p_name, c.name as c_name, b.status, rd.restitute_date from book b, author a,"
				+ "category c, publisher p, reservationdetails rd where b.aid=a.id and b.pid=p.id and b.cid=c.id and b.id=rd.book_id and rd.user_id=?";
		
		
		
		
		return template.query(query, new Object[]{user.getId()}, new ReservationDetailsMapper());
	}

}
