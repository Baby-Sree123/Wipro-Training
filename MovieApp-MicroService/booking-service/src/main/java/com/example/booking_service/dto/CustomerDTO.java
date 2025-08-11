package com.example.booking_service.dto;


import java.time.LocalDate;


import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class CustomerDTO{
	private Long id;
    private String name;
    private String email;
    

	    

}
