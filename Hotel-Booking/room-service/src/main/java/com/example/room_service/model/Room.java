package com.example.room_service.model;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Room {
	 @Id

     @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String roomNumber;

	private String type; 

	private double price;

	public Long getId() {
		return id;
	}
	

	public Room() {
		super();
	}


	public void setId(Long id) {
		this.id = id;
	}

	public String getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Room(Long id, String roomNumber, String type, double price) {
		super();
		this.id = id;
		this.roomNumber = roomNumber;
		this.type = type;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Room [id=" + id + ", roomNumber=" + roomNumber + ", type=" + type + ", price=" + price + "]";
	}
	
	
	
	

}
