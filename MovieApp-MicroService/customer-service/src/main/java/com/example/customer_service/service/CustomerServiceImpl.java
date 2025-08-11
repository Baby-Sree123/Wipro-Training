package com.example.customer_service.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.customer_service.client.BookingClient;
import com.example.customer_service.dto.BookingDTO;
import com.example.customer_service.dto.CustomerBookingResponseDTO;
import com.example.customer_service.model.Customer;
import com.example.customer_service.repository.CustomerRepository;
import com.example.customer_service.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    // This is a placeholder for a booking service/client. Replace with your actual booking service.
    @Autowired
    private BookingClient bookingClient;

    @Override
    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Customer not found with id: " + id));
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        if(customer.getId() == null || !customerRepository.existsById(customer.getId())) {
            throw new RuntimeException("Customer not found or ID is null");
        }
        return customerRepository.save(customer);
    }

    @Override
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> searchCustomersByName(String name) {
        // Make sure your repository has this method declared
        return customerRepository.findByNameContainingIgnoreCase(name);
    }

    @Override
    public List<Customer> getCustomersByEmailDomain(String domain) {
        // Make sure your repository has this method declared
        return customerRepository.findByEmailEndingWith(domain);
    }

    @Override
    public CustomerBookingResponseDTO getCustomerWithBookings(Long customerId) {
        Customer customer = getCustomerById(customerId);
        List<BookingDTO> bookings = bookingClient.getBookingsByCustomerId(customerId);
        return new CustomerBookingResponseDTO();
    }

    @Override
    public List<BookingDTO> getBookingsByCustomerId(Long customerId) {
        return bookingClient.getBookingsByCustomerId(customerId);
    }
}
