package com.service;

import java.util.UUID;
import com.model.Ticket;

public class TicketService {
    private FlightService flightService;

    // Dependency Injection setter
    public void setFlightService(FlightService flightService) {
        this.flightService = flightService;
    }

    // Confirm booking and create a ticket if seats are available
    public String confirmBooking(String flightId, String userId) {
        if (flightService.isSeatAvailable(flightId)) {
            flightService.bookSeat(flightId);

            // Generate a unique ticket ID
            String ticketId = UUID.randomUUID().toString();
            Ticket ticket = new Ticket(ticketId, userId, flightId, "CONFIRMED");

            // Here you could save the ticket if needed (DB or in-memory storage)

            return "Booking confirmed for " + userId + " on " + flightId + " | Ticket ID: " + ticketId;
        } else {
            return "Flight " + flightId + " is full";
        }
    }
}
