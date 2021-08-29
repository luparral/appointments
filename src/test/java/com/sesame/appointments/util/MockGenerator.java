package com.sesame.appointments.util;

import com.sesame.appointments.model.*;

import java.util.List;

public class MockGenerator {

    public Appointment createMockAppointment(Doctor doctor, Integer durationInMinutes, String time, MedicalService service, Location location, String id){
        return new Appointment(doctor, durationInMinutes, time, service, location, id);
    }

    public MedicalService createMockService(String name, Integer price) {
        return new MedicalService(name, price);
    }

    public Doctor createMockDoctor(String firstName, String lastName) {
        return new Doctor(firstName, lastName);
    }

    public Location createMockLocation(String name, String timeZoneCode){
        return new Location(name, timeZoneCode);
    }
    private DoctorAppointment createMockDoctorAppointment(String firstName, String lastName, List<AppointmentByLocation> appointmentByLocations){
        return new DoctorAppointment(firstName, lastName, appointmentByLocations);
    }

    private AppointmentByLocation createMockAppointmentByLocation(String locationName, List<ShortAppointment> appointments){
        return new AppointmentByLocation(locationName, appointments);
    }

    private ShortAppointment createMockShortAppointment(String id, String startDateTime, String duration, MedicalService service){
        return new ShortAppointment(id, startDateTime, duration, service);
    }

}
