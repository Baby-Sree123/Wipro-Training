package com.example.customer_service.dto;

import java.util.List;

public class CustomerBookingResponseDTO {

    private CustomerDTO customer;
    private List<BookingDTO> bookings;

    // No-arg constructor
    public CustomerBookingResponseDTO() {
    }

    // All-args constructor
    public CustomerBookingResponseDTO(CustomerDTO customer, List<BookingDTO> bookings) {
        this.customer = customer;
        this.bookings = bookings;
    }

    // Getters and Setters
    public CustomerDTO getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDTO customer) {
        this.customer = customer;
    }

    public List<BookingDTO> getBookings() {
        return bookings;
    }

    public void setBookings(List<BookingDTO> bookings) {
        this.bookings = bookings;
    }

    // toString method
    @Override
    public String toString() {
        return "CustomerBookingResponseDTO{" +
                "customer=" + customer +
                ", bookings=" + bookings +
                '}';
    }
}