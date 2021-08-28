package com.sesame.appointments.service;
import com.fasterxml.jackson.core.JsonProcessingException;
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

    @Autowired
    public AppointmentsService(@Qualifier("inMemoryDao") AppointmentDao appointmentDao, AppointmentErrorService appointmentErrorService) {
        this.appointmentDao = appointmentDao;
        this.appointmentErrorService = appointmentErrorService;
    }

    public List<Appointment> getValidAppointments() { return appointmentDao.getValidAppointments();}
    public List<Appointment> getInvalidAppointments() {return appointmentDao.getInvalidAppointments();}


    public void loadAllFromFile() {
        JSONParser parser = new JSONParser();
        try {
            Object obj  = parser.parse(new FileReader("./data.json"));
            JSONArray jsonArray = (JSONArray) obj;
            for (int i = 0; i <jsonArray.size(); i++) {
                JSONObject jsonAppointment = (JSONObject)jsonArray.get(i);
                createAppointment(jsonAppointment);
            }
            System.out.println("Finished loading all appointments.");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public void createAppointment(JSONObject appointment) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Appointment newAppointment = objectMapper.readValue(appointment.toString(), Appointment.class);
        if (newAppointment.valid()){
            appointmentDao.createAppointment(newAppointment);
        } else {
            appointmentErrorService.addAppointmentError(newAppointment);
        }
    }



}



