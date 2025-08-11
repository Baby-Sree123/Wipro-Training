package com.example.booking_service.client;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.cloud.openfeign.FeignClient;

import com.example.booking_service.dto.CustomerDTO;


@FeignClient(name = "Customer-Service", url = "http://localhost:2222")

public interface CustomerClient {
	 @GetMapping("/customers/{id}")
	    CustomerDTO getCustomerById(@PathVariable("id") Long id);
	}
