package com.model;

public class AppointmentService {
    private DoctorRepository doctorRepository;

    public void setDoctorRepository(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public String book(String doctorId, String dateStr) {
        if (doctorRepository.isDoctorAvailable(doctorId, dateStr)) {
            return "Appointment confirmed";
        } else {
            return "Doctor not available";
        }
    }
}
