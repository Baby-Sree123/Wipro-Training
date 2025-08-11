package com.example.customer_service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.customer_service.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

	  List<Customer> findByNameContainingIgnoreCase(String name);
	    List<Customer> findByEmailEndingWith(String domain);
}

