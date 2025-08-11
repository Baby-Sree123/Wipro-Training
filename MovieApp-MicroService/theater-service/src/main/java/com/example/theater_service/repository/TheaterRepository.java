package com.example.theater_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.theater_service.model.Theater;

public interface TheaterRepository extends JpaRepository<Theater, Long>{

}
