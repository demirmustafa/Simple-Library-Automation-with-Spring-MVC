package com.library_automation.service;

import java.util.List;

import com.library_automation.classes.Book;
import com.library_automation.classes.Reservation;

public interface ReservationService {
	
	public void reserveBook(Reservation reservation);
	
	public void restituteBook(Reservation reservation);
	
	public List<Book> getMyActiveReservations(int userId);

}
