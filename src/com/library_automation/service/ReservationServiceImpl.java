package com.library_automation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library_automation.classes.Book;
import com.library_automation.classes.Reservation;
import com.library_automation.dao.ReservationsDAO;


@Service
public class ReservationServiceImpl implements ReservationService {
	
	@Autowired
	private ReservationsDAO reservationsDAO;

	@Override
	public void reserveBook(Reservation reservation) {
		// TODO Auto-generated method stub
		
		reservationsDAO.reserveBook(reservation);

	}

	@Override
	public void restituteBook(Reservation reservation) {
		// TODO Auto-generated method stub
		reservationsDAO.restituteBook(reservation);

	}

	@Override
	public List<Book> getMyActiveReservations(int userId) {
		// TODO Auto-generated method stub
		return reservationsDAO.getMyActiveReservations(userId);
	}

}
