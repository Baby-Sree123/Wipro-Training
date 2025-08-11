package com.customer.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.customer.dto.BookingDTO;
import com.customer.model.Customer;
import com.customer.service.CustomerService;


import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerController {
	
	private final CustomerService customerService;

    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable Long id) {
        return customerService.getCustomerById(id);
    }
    @PostMapping
    public Customer createCustomer(@RequestBody Customer customer){
    	return customerService.saveCustomer(customer);
    }

    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @PutMapping
    public Customer updateCustomer(@RequestBody Customer customer) {
        if (customer.getId() == null) {
            throw new IllegalArgumentException("Customer ID is required for update");
        }
        return customerService.updateCustomer(customer);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
    }

    @GetMapping("/search")
    public List<Customer> searchCustomersByName(@RequestParam String name) {
        return customerService.searchCustomersByName(name);
    }

    @GetMapping("/email-domain")
    public List<Customer> getCustomersByEmailDomain(@RequestParam String domain) {
        return customerService.getCustomersByEmailDomain(domain);
    }
    
    @GetMapping("/{customerId}/bookings-list")
    public List<BookingDTO> getBookingsByCustomerId(@PathVariable Long customerId) {
        return customerService.getBookingsByCustomerId(customerId);
    }


}
