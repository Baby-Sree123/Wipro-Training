package com.example.hotel_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hotel_service.model.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Long> {

}
