package com.sesame.appointments.service;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sesame.appointments.dao.AppointmentDao;
import com.sesame.appointments.model.Appointment;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONArray;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class AppointmentsService {

    private final AppointmentDao appointmentDao;
    private final AppointmentErrorService appointmentErrorService;
    private final RestService restService;

    @Autowired
    public AppointmentsService(@Qualifier("inMemoryDao") AppointmentDao appointmentDao, AppointmentErrorService appointmentErrorService, RestService restService) {
        this.appointmentDao = appointmentDao;
        this.appointmentErrorService = appointmentErrorService;
        this.restService = restService;
    }

    public List<Appointment> getValidAppointments() { return appointmentDao.getValidAppointments();}

    public void loadAllFromRestService() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String response  = restService.getAppointmentsPlainJSON();
            List<Appointment> appointmentList = objectMapper.readValue(response, new TypeReference<List<Appointment>>(){});
            createAppointments(appointmentList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void createAppointments(List<Appointment> appointments){
        appointments.forEach(appointment -> {
            if (appointment.valid()){
                appointmentDao.createAppointment(appointment);
            } else {
                appointmentErrorService.addAppointmentError(appointment);
            }
        });
    }



}



