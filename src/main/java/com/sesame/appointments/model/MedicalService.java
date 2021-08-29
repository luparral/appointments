package com.sesame.appointments.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MedicalService {
    private final String name;
    private final Integer price;

    public MedicalService(@JsonProperty("name") String name,
                          @JsonProperty("price") Integer price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public Integer getPrice() {
        return price;
    }

    public boolean valid() {
        return this.price != 0 && this.name != null;
    }
}
