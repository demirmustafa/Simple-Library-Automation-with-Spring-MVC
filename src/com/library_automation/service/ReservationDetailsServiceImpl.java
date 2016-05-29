package com.library_automation.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library_automation.classes.Book;
import com.library_automation.classes.Reservation;
import com.library_automation.classes.ReservationDetails;
import com.library_automation.classes.User;
import com.library_automation.dao.ReservationDetailsDAO;

@Service
public class ReservationDetailsServiceImpl implements ReservationDetailsService {
	
	private String reservDate, restDate;
	private Calendar cal;
	private SimpleDateFormat format;
	private Date reservationDate, restituteDate;
	
	@Autowired
	private ReservationDetailsDAO rdDAO;

	@Override
	public void setDates(User user, Book book) {
		// TODO Auto-generated method stub
		
		reservationDate = new Date();
		restituteDate = new Date();
		cal = Calendar.getInstance();
		cal.setTime(restituteDate);
		cal.add(Calendar.DATE, 14);
		restituteDate = cal.getTime();
		
		format = new SimpleDateFormat("yyyy-MM-dd");
		reservDate = format.format(reservationDate);
		restDate = format.format(restituteDate);
		
		rdDAO.setDates(user.getId(), book.getId(), reservDate, restDate);
		
		
	}

	@Override
	public List<ReservationDetails> getMyReservations(User user) {
		// TODO Auto-generated method stub
		
		
		return rdDAO.getMyReservations(user);
	}
	
	

	

}
