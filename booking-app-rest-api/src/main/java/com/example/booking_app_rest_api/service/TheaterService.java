package com.example.booking_app_rest_api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.booking_app_rest_api.Repository.TheaterRepository;
import com.example.booking_app_rest_api.model.Theater;



@Service
public class TheaterService {

	@Autowired
	private TheaterRepository theaterRepository;
	

	public TheaterService(TheaterRepository theaterRepository) {
		super();
		this.theaterRepository = theaterRepository;
	}
	

	public List<Theater> getAllTheaters(){
		return theaterRepository.findAll();
	}
	
	public Optional<Theater> getTheaterById(Long id) {
		return theaterRepository.findById(id);	
	}
	
	public Theater saveTheater(Theater theater) {
		return theaterRepository.save(theater);
	}
	
	public void deleteTheater(Long id) {
		theaterRepository.deleteById(id);
	}
	
}