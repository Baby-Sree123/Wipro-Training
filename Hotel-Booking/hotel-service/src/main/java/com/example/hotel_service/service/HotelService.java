package com.example.hotel_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hotel_service.model.Hotel;
import com.example.hotel_service.repository.HotelRepository;
@Service
public class HotelService {
	
	@Autowired
	private HotelRepository hotelRepository;
	
	public List<Hotel> getAllHotels() {
		return hotelRepository.findAll();
	}
	
	public Hotel saveHotel(Hotel hotel) {
		return hotelRepository.save(hotel);
	}
	
	public Hotel getHotelById(Long Id) {
		return hotelRepository.findById(Id).get();
	}
	
	public void deleteHotel(Long id) {
		hotelRepository.deleteById(id);
	}

}
