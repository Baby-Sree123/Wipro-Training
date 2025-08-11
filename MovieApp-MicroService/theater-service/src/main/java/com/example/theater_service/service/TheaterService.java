package com.example.theater_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.theater_service.model.Theater;
import com.example.theater_service.repository.TheaterRepository;

public interface TheaterService {
	
	 Theater createTheater(Theater theater);
	 Theater getTheaterById(Long id);
    List<Theater> getAllTheaters();
    Theater updateTheater(Long id, Theater theater);
    void deleteTheater(Long id);

}
