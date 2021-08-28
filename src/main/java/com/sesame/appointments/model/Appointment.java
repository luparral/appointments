package com.sesame.appointments.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

import static com.sesame.appointments.util.ConstantUtil.*;

public class Appointment {
    private final Doctor doctor;
    private final int durationInMinutes;
    private final String time;
    private final MedicalService service;
    private final Location location;
    private final String id;

    public Appointment(@JsonProperty("doctor") Doctor doctor,
                       @JsonProperty("durationInMinutes") int durationInMinutes,
                       @JsonProperty("time") String time,
                       @JsonProperty("service") MedicalService service,
                       @JsonProperty("location") Location location,
                       @JsonProperty("id") String id) {
        this.doctor = doctor;
        this.durationInMinutes = durationInMinutes;
        this.time = time;
        this.service = service;
        this.location = location;
        this.id = id;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public int getDurationInMinutes() {
        return durationInMinutes;
    }

    public String getTime() {
        return time;
    }

    public MedicalService getService() {
        return service;
    }

    public Location getLocation() {
        return location;
    }

    public String getId() {
        return id;
    }

    private boolean hasValidDoctor(){
        if (this.doctor != null) {
            return this.doctor.valid();
        }
        return false;
    }

    private boolean hasValidDurationInMinutes(){
        return this.durationInMinutes != 0;
    }

    private boolean hasValidTime(){
        return this.time != null;
    }

    private boolean hasValidService(){
        if (this.service != null) {
            return this.service.valid();
        }
        return false;
    }

    private boolean hasValidLocation(){
        if(this.location != null){
            return this.location.valid();
        }
        return false;
    }

    private boolean hasValidId(){
        return this.id != null;
    }

    public boolean valid(){
        return hasValidId() && hasValidDoctor() && hasValidTime() && hasValidLocation() && hasValidService() && hasValidDurationInMinutes();
    }

    public List<String> getErrors(){
        List<String> result = new ArrayList<>();
        if (!hasValidDoctor()){
            result.add(INVALID_DOCTOR);
        }
        if (!hasValidDurationInMinutes()){
            result.add(INVALID_DURATION_IN_MINUTES);
        }
        if (!hasValidTime()){
            result.add(INVALID_TIME);
        }
        if (!hasValidService()){
            result.add(INVALID_SERVICE);
        }
        if (!hasValidLocation()){
            result.add(INVALID_LOCATION);
        }
        if (!hasValidId()){
            result.add(INVALID_ID);
        }
        return result;
    }
}
