package com.example.booking_service.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MovieDTO {

	   private Long id;
	    private String title;
	    private String genre;

}
