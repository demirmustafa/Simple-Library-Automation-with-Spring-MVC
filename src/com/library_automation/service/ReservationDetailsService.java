package com.library_automation.service;

import java.util.Date;
import java.util.List;

import com.library_automation.classes.Book;
import com.library_automation.classes.ReservationDetails;
import com.library_automation.classes.User;

public interface ReservationDetailsService {
	
	public void setDates(User user, Book book);
	
	public List<ReservationDetails> getMyReservations(User user);

}
