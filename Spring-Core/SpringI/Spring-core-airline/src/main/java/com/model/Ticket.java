package com.model;

public class Ticket {
	
	String ticketId;
	String userId;
	String flightId;
	String status;
	
	public Ticket() {
		
	}

	public Ticket(String ticketId, String userId, String flightId, String status) {
		super();
		this.ticketId = ticketId;
		this.userId = userId;
		this.flightId = flightId;
		this.status = status;
	}

	public String getTicketId() {
		return ticketId;
	}

	public void setTicketId(String ticketId) {
		this.ticketId = ticketId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getFlightId() {
		return flightId;
	}

	public void setFlightId(String flightId) {
		this.flightId = flightId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "TicketService [ticketId=" + ticketId + ", userId=" + userId + ", flightId=" + flightId + ", status="
				+ status + "]";
	}
	
	
	
	

}
