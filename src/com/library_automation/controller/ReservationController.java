package com.library_automation.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.library_automation.classes.Book;
import com.library_automation.classes.Reservation;
import com.library_automation.dao.UsersDAO;
import com.library_automation.service.ReservationDetailsService;
import com.library_automation.service.ReservationService;

@Controller
public class ReservationController {
	
	
	@Autowired
	private ReservationService reservationService;
	
	@Autowired
	private UsersDAO usersDAO;
	
	@Autowired
	private ReservationDetailsService service;
	
	@RequestMapping(value="/user/Available/", method=RequestMethod.POST)
	public String reservation(ModelMap model, HttpServletRequest req){
		
		
		
		
		HttpSession session = req.getSession();
		String username = String.valueOf(session.getAttribute("username"));
		System.out.println(username);
		com.library_automation.classes.User authUser = usersDAO.getAuthenticatedUser(username);
		Reservation reservation = new Reservation();
		reservation.setBook(new Book(Integer.parseInt(req.getParameter("book_id"))));
		reservation.setUser(authUser);
		
		service.setDates(authUser, new Book(Integer.parseInt(req.getParameter("book_id"))));
		
		reservationService.reserveBook(reservation);
		
		return "welcome";
	}
	
	@RequestMapping("/user/CheckedOut/")
	public String checkedOut(){
		
		return "redirect:/search/";
	}
	
	@RequestMapping(value="/user/restitute/")
	public String restituteBook(HttpServletRequest request){
		
		HttpSession session = request.getSession();
		 
		Reservation reservation = new Reservation();
		reservation.setUser(usersDAO.getAuthenticatedUser(String.valueOf(session.getAttribute("username"))));
		reservation.setBook(new Book(Integer.parseInt(request.getParameter("book_id"))));
		
		reservationService.restituteBook(reservation);
		
		return "redirect:/profile/";
	}
	

}
