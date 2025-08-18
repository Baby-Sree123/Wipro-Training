package com.example.billing_service.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.billing_service.dto.BillingDTO;
import com.example.billing_service.dto.PatientDTO;
import com.example.billing_service.feign.PatientClient;
import com.example.billing_service.model.Billing;
import com.example.billing_service.repository.BillingRepository;

@Service
public class BillingService {

    @Autowired
    BillingRepository billingRepository;

    @Autowired
    PatientClient patientClient;

    // Generate a new bill
    public Billing generateBill(Billing bill) {
        bill.setBillingDate(LocalDate.now());
        bill.setPaid(false);
        return billingRepository.save(bill);
    }

    public List<BillingDTO> getAllBillsFull() {
        List<Billing> bills = billingRepository.findAll();
        List<BillingDTO> result = new ArrayList<>();

        for (Billing bill : bills) {
            PatientDTO patient = patientClient.getPatientById(bill.getPatientId());

            BillingDTO dto = new BillingDTO();
            dto.setId(bill.getId());
            dto.setMedicalRecordId(bill.getMedicalRecordId());
            dto.setAmount(bill.getAmount());
            dto.setBillingDate(bill.getBillingDate());
            dto.setPaid(bill.isPaid());
            dto.setPatient(patient);

            result.add(dto);
        }

        return result;
    }

    public List<BillingDTO> getBillsByPatient(Long patientId) {
        List<Billing> allBills = billingRepository.findAll(); 
        List<BillingDTO> result = new ArrayList<>();

        for (Billing bill : allBills) {
            if (bill.getPatientId().equals(patientId)) { 
                PatientDTO patient = patientClient.getPatientById(patientId);

                BillingDTO dto = new BillingDTO();
                dto.setId(bill.getId());
                dto.setMedicalRecordId(bill.getMedicalRecordId());
                dto.setAmount(bill.getAmount());
                dto.setBillingDate(bill.getBillingDate());
                dto.setPaid(bill.isPaid());
                dto.setPatient(patient);

                result.add(dto);
            }
        }

        return result;
    }

    
    public Billing payBill(Long id) {
        Billing bill = billingRepository.findById(id).orElse(null);
        if (bill != null) {
            bill.setPaid(true);
            billingRepository.save(bill);
        }
        return bill;
    }

    
    public void deleteBill(Long id) {
        billingRepository.deleteById(id);
    }
}
