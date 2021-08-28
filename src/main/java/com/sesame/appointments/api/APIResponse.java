package com.sesame.appointments.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sesame.appointments.model.AppointmentError;
import com.sesame.appointments.model.DoctorAppointment;

import java.util.List;

public class APIResponse {

    private final List<DoctorAppointment> doctorAppointments;
    private final List<AppointmentError> appointmentErrors;

    public APIResponse(@JsonProperty("content") List<DoctorAppointment> doctorAppointments,
                       @JsonProperty("errors") List<AppointmentError> appointmentErrors) {
        this.doctorAppointments = doctorAppointments;
        this.appointmentErrors = appointmentErrors;
    }


    public List<DoctorAppointment> getDoctorAppointments() {
        return doctorAppointments;
    }

    public List<AppointmentError> getAppointmentErrors() {
        return appointmentErrors;
    }
}
