package com.sesame.appointments.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class AppointmentByLocation {
    private final String locationName;
    private  List<ShortAppointment> appointments;

    public AppointmentByLocation(@JsonProperty("locationName") String locationName,
                                 @JsonProperty("appointments") List<ShortAppointment> appointments) {
        this.locationName = locationName;
        this.appointments = appointments;
    }
    public String getLocationName() {
        return locationName;
    }
    public List<ShortAppointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<ShortAppointment> appointments) {
        this.appointments = appointments;
    }


}