package com.sesame.appointments.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class AppointmentError {
    private final String errorCode;
    private final List<String> appointmentsIds;

    public AppointmentError(@JsonProperty("errorCode") String errorCode, @JsonProperty("ids") List<String> ids) {
        this.errorCode = errorCode;
        this.appointmentsIds = ids;
    }

    public List<String> getIds() {
        return appointmentsIds;
    }

    public String getErrorCode() {
        return errorCode;
    }
}


