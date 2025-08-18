package com.example.medical_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.medical_service.model.Medical;


@Repository
public interface MedicalRepository extends JpaRepository<Medical, Long> {
}
