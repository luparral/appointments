package com.sesame.appointments.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Location {
    private final String name;
    private final String timeZoneCode;


    public Location(@JsonProperty("name") String name,
                    @JsonProperty("timeZoneCode") String timeZoneCode) {
        this.name = name;
        this.timeZoneCode = timeZoneCode;
    }

    public String getName() {
        return name;
    }

    public String getTimeZoneCode() {
        return timeZoneCode;
    }

    public boolean valid() {
        return this.name != null && this.timeZoneCode != null;
    }
}
