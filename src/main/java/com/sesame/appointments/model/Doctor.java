package com.sesame.appointments.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Doctor {
    private final String firstName;
    private final String lastName;

    public Doctor(@JsonProperty("firstName") String firstName,
                  @JsonProperty("lastName")String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public boolean valid() {
        return this.firstName != null && this.lastName != null;
    }
}
