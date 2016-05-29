package com.library_automation.classes;

import java.util.Date;

public class ReservationDetails {

	private int id;
	private User user;
	private Book book;
	private Date reservationDate;
	private Date restituteDate;

	public ReservationDetails() {
		super();
	}

	public ReservationDetails(User user, Book book, Date reservationDate, Date restituteDate) {
		super();
		this.user = user;
		this.book = book;
		this.reservationDate = reservationDate;
		this.restituteDate = restituteDate;
	}

	public ReservationDetails(int id, User user, Book book, Date reservationDate, Date restituteDate) {
		super();
		this.id = id;
		this.user = user;
		this.book = book;
		this.reservationDate = reservationDate;
		this.restituteDate = restituteDate;
	}

	public ReservationDetails(Book book, Date restituteDate) {
		super();
		this.book = book;
		this.restituteDate = restituteDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Date getReservationDate() {
		return reservationDate;
	}

	public void setReservationDate(Date reservationDate) {
		this.reservationDate = reservationDate;
	}

	public Date getRestituteDate() {
		return restituteDate;
	}

	public void setRestituteDate(Date restituteDate) {
		this.restituteDate = restituteDate;
	}

}
