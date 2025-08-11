package com.example.booking_service.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Bookings")
public class Booking {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Long customerId;
    private Long movieId;
    private String seatNumber;
    private LocalDate bookingDate;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public Long getMovieId() {
		return movieId;
	}
	public void setMovieId(Long movieId) {
		this.movieId = movieId;
	}
	public String getSeatNumber() {
		return seatNumber;
	}
	public void setSeatNumber(String seatNumber) {
		this.seatNumber = seatNumber;
	}
	public LocalDate getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}
	public Booking(Long id, Long customerId, Long movieId, String seatNumber, LocalDate bookingDate) {
		super();
		this.id = id;
		this.customerId = customerId;
		this.movieId = movieId;
		this.seatNumber = seatNumber;
		this.bookingDate = bookingDate;
	}
	public Booking() {
		super();
	}
	@Override
	public String toString() {
		return "Booking [id=" + id + ", customerId=" + customerId + ", movieId=" + movieId + ", seatNumber="
				+ seatNumber + ", bookingDate=" + bookingDate + "]";
	}
}
	