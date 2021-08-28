package com.sesame.appointments.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MedicalService {
    private final String name;
    private final int price;

    public MedicalService(@JsonProperty("name") String name,
                          @JsonProperty("price") int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public boolean valid() {
        return this.price != 0 && this.name != null;
    }
}
