package com.model;

public class Flight {
    private String flightId;
    private String origin;
    private String destination;
    private int availableSeats;



    public Flight() {
    	
    }

   
    public Flight(String flightId, String origin, String destination, int availableSeats) {
        this.flightId = flightId;
        this.origin = origin;
        this.destination = destination;
        this.availableSeats = availableSeats;
    }

   
    public Flight(String flightId, String origin, String destination) {
        this(flightId, origin, destination, 2); 
    }

  
    public String getFlightId() {
        return flightId;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    
    public void reduceSeat() {
        if (availableSeats > 0) {
            availableSeats--;
        }
    }
}
