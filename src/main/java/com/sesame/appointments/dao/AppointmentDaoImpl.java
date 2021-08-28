package com.sesame.appointments.dao;

import com.sesame.appointments.model.Appointment;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("inMemoryDao")
public class AppointmentDaoImpl implements AppointmentDao{

    private static List<Appointment> DB = new ArrayList<>();

    @Override
    public Appointment createAppointment(Appointment a) {
        DB.add(new Appointment(a.getDoctor(), a.getDurationInMinutes(), a.getTime(), a.getService(), a.getLocation(), a.getId()));
        return a;
    }

    @Override
    public List<Appointment> getAllAppointments() {
        return DB;
    }

}
