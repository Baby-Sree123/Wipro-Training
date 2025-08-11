package com.example.customer_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.customer_service.dto.BookingDTO;
import com.example.customer_service.dto.CustomerBookingResponseDTO;
import com.example.customer_service.model.Customer;
import com.example.customer_service.repository.CustomerRepository;

@Service
public interface CustomerService {
	
	Customer getCustomerById(Long id);

    List<Customer> getAllCustomers();

    Customer updateCustomer(Customer customer);

    void deleteCustomer(Long id);
    
    Customer saveCustomer(Customer customer);

    List<Customer> searchCustomersByName(String name);

    List<Customer> getCustomersByEmailDomain(String domain);

    CustomerBookingResponseDTO getCustomerWithBookings(Long customerId);
    
    List<BookingDTO> getBookingsByCustomerId(Long customerId);

}
