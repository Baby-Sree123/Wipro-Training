package com.example.booking_service.dto;


import java.time.LocalDate;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BookingDTO {

	private Long id;
    private Long customerId;
    private Long movieId;
    private String seatNumber;
    private LocalDate bookingDate;

}
