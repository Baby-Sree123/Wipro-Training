package com.example.booking_service.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.booking_service.dto.*;
import com.example.booking_service.dto.RoomDTO;
import com.example.booking_service.model.Booking;
import com.example.booking_service.service.BookingService;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping
    public Booking createBooking(@RequestBody Booking booking) {
        return bookingService.saveBooking(booking);
    }

    @GetMapping
    public List<Booking> getAllBookings() {
        return bookingService.getAllBookings();
    }

    @GetMapping("/{id}")
    public Optional<Booking> getBookingById(@PathVariable Long id) {
        return bookingService.getBookingById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteBooking(@PathVariable Long id) {
        bookingService.deleteBooking(id);
    }

    @GetMapping("/room/{roomId}")
    public RoomDTO getRoomDetails(@PathVariable Long roomId) {
        return bookingService.getRoomDetails(roomId);
    }

    @GetMapping("/{id}/with-room")
    public ResponseEntity<BookingResponseDTO> getBookingWithRoom(@PathVariable Long id) {
        Optional<Booking> bookingOpt = bookingService.getBookingById(id);
        if (bookingOpt.isPresent()) {
            Booking booking = bookingOpt.get();

            Long roomId = booking.getRoomId();
            if (roomId == null) {
                return ResponseEntity.badRequest().body(null);
            }

            RoomDTO roomDTO = bookingService.getRoomDetails(roomId);

            BookingResponseDTO dto = new BookingResponseDTO();
            dto.setId(booking.getId());
            dto.setCheckInDate(booking.getCheckInDate());
            dto.setCheckOutDate(booking.getCheckOutDate());
            dto.setRoom(roomDTO);
            dto.setRoomId(roomId);

            return ResponseEntity.ok(dto);  // should return full BookingResponseDTO
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
