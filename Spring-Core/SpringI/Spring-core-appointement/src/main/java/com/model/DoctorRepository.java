package com.model;

import java.util.List;
import java.util.Map;

public class DoctorRepository {
    private Map<String, List<String>> doctorSchedules;

    public void setDoctorSchedules(Map<String, List<String>> doctorSchedules) {
        this.doctorSchedules = doctorSchedules;
    }

    public boolean isDoctorAvailable(String doctorId, String dateStr) {
        List<String> availableDates = doctorSchedules.get(doctorId);
        return availableDates != null && availableDates.contains(dateStr);
    }
}
