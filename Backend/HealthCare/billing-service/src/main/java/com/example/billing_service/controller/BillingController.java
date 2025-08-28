package com.example.billing_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.billing_service.dto.BillingDTO;
import com.example.billing_service.model.Billing;
import com.example.billing_service.service.BillingService;

@RestController
@RequestMapping("/api/billing")
public class BillingController {
	
	 @Autowired
	    BillingService billingService;

	    @PostMapping("/generate")
	    public Billing createBill(@RequestBody Billing bill) {
	        return billingService.generateBill(bill);
	    }

	  
	    @GetMapping("/all")
	    public List<BillingDTO> getAllBills() {
	        return billingService.getAllBillsFull();
	    }

	
	    @GetMapping("/patient/{patientId}")
	    public List<BillingDTO> getBillsByPatient(@PathVariable Long patientId) {
	        return billingService.getBillsByPatient(patientId);
	    }

	
	    @PutMapping("/pay/{id}")
	    public Billing payBill(@PathVariable Long id) {
	        return billingService.payBill(id);
	    }

	
	    @DeleteMapping("/delete/{id}")
	    public String deleteBill(@PathVariable Long id) {
	        billingService.deleteBill(id);
	        return "Bill with ID " + id + " deleted successfully.";
	    }
}
