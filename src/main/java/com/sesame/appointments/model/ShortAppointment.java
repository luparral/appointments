package com.sesame.appointments.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ShortAppointment {
    private final String appointmentId;
    private final String startDateTime; // This has to be an ISO Date.
    private final String duration;
    private final MedicalService service;

    public ShortAppointment(@JsonProperty("appointmentId") String appointmentId,
                            @JsonProperty("startDateTime") String startDateTime,
                            @JsonProperty("duration") String duration,
                            @JsonProperty("service") MedicalService service) {
        this.appointmentId = appointmentId;
        this.startDateTime = startDateTime;
        this.duration = duration;
        this.service = service;
    }

    public String getAppointmentId() {
        return appointmentId;
    }

    public String getStartDateTime() {
        return startDateTime;
    }

    public String getDuration() {
        return duration;
    }

    public MedicalService getService() {
        return service;
    }
}