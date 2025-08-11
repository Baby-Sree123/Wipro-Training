package com.example.booking_app_rest_api.controller;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.booking_app_rest_api.model.Customer;
import com.example.booking_app_rest_api.service.CustomerService;




@RestController
@RequestMapping("/api")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	public CustomerController(CustomerService customerService) {
		super();
		this.customerService = customerService;
	}


	@GetMapping("/customer")
	public List<Customer> getAllCustomers(){
		return customerService.getAllCustomers();	
	}
	
	
	@GetMapping("/customer/{id}")
	public Optional<Customer> getMovie(@PathVariable Long id) {
		return customerService.getCustomerById(id);
	}
	
	
	@PostMapping("/customers")
	public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
	    Customer savedCustomer = customerService.saveCustomer(customer);
	    return new ResponseEntity<>(savedCustomer, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/customer/{id}")
    public void deleteMovie(@PathVariable Long id) {
		customerService.deleteCustomer(id);
    }


}