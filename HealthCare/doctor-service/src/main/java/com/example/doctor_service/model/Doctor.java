package com.example.doctor_service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String doctname;
    private String doctemail;
    private String doctphone;
    private String specialization;
    private String schedule;

    public Doctor() {}

    public Doctor(Long id, String doctname, String doctemail, String doctphone, String specialization, String schedule) {
        this.id = id;
        this.doctname = doctname;
        this.doctemail = doctemail;
        this.doctphone = doctphone;
        this.specialization = specialization;
        this.schedule = schedule;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDoctname() {
        return doctname;
    }

    public void setDoctname(String doctname) {
        this.doctname = doctname;
    }

    public String getDoctemail() {
        return doctemail;
    }

    public void setDoctemail(String doctemail) {
        this.doctemail = doctemail;
    }

    public String getDoctphone() {
        return doctphone;
    }

    public void setDoctphone(String doctphone) {
        this.doctphone = doctphone;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }
}
