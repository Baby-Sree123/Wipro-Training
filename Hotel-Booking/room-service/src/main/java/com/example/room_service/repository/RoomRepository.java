package com.example.room_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.room_service.model.Room;

public interface RoomRepository extends JpaRepository<Room, Long>{

	

}
