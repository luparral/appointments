package com.sesame.appointments.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class DoctorAppointment {
    private final String firstName;
    private final String lastName;
    private  List<AppointmentByLocation> appointmentsByLocation;

    public DoctorAppointment(@JsonProperty("firstName") String firstName,
                             @JsonProperty("lastName") String lastName,
                             @JsonProperty("appointmentsByLocation") List<AppointmentByLocation> appointmentsByLocation) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.appointmentsByLocation = appointmentsByLocation;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public List<AppointmentByLocation> getAppointmentsByLocation() {
        return appointmentsByLocation;
    }

    public void setAppointmentsByLocation(List<AppointmentByLocation> appointmentsByLocation) {
        this.appointmentsByLocation = appointmentsByLocation;
    }
}
