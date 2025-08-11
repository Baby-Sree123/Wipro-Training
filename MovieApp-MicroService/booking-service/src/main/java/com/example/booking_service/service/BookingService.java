package com.example.booking_service.service;

import com.example.booking_service.model.Booking;

import java.util.List;
import java.util.Optional;

public interface BookingService {

    List<Booking> getAllBookings();

    Booking saveBooking(Booking booking);

    Optional<Booking> getBookingById(Long id);

    void deleteBooking(Long id);
}
