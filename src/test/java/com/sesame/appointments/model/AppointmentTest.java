package com.sesame.appointments.model;

import org.junit.jupiter.api.Test;

import javax.print.Doc;

import static org.junit.jupiter.api.Assertions.*;

class AppointmentTest {

    private final Doctor doctor = new Doctor("Bruce", "Wayne");
    private final int duration = 10;
    private final String time = "2021-08-27 11:09:00";
    private final MedicalService service = new MedicalService("Physiotherapy consultation", 50);
    private final Location location = new Location("Gotham", "America/Somewhere");
    private final String id = "72842fe1-3e6b-4139-b7d6-319e4efeb8cf";

    @Test
    void validAppointmentIsValid() {
        Appointment appointment = new Appointment(doctor, duration, time, service, location, id);
        assertTrue (appointment.valid());
    }

    @Test
    void invalidLocationAppointmentIsNotValid() {
        Appointment appointment = new Appointment(doctor, duration, time, service, null, id);
        assertFalse (appointment.valid());
    }

    @Test
    void invalidDoctorAppointmentIsNotValid() {
        Appointment appointment = new Appointment(null, duration, time, service, location, id);
        assertFalse (appointment.valid());
    }

    @Test
    void invalidServiceAppointmentIsNotValid() {
        Appointment appointment = new Appointment(doctor, duration, time, null, location, id);
        assertFalse (appointment.valid());
    }
}