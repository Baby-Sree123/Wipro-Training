package com.service;

import java.util.Map;
import com.model.Flight;

public class FlightService {
    private Map<String, Flight> flights;

    // Setter for dependency injection
    public void setFlights(Map<String, Flight> flights) {
        this.flights = flights;
    }

    // Check if seats are available for the given flightId
    public boolean isSeatAvailable(String flightId) {
        Flight flight = flights.get(flightId);
        return flight != null && flight.getAvailableSeats() > 0;
    }

    // Book a seat by reducing availableSeats for the flight
    public void bookSeat(String flightId) {
        Flight flight = flights.get(flightId);
        if (flight != null && flight.getAvailableSeats() > 0) {
            flight.reduceSeat();
        }
    }
}
