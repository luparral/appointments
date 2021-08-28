package com.sesame.appointments.dao;

import com.sesame.appointments.model.Appointment;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("inMemoryDao")
public class AppointmentDaoImpl implements AppointmentDao{

    private static List<Appointment> DB = new ArrayList<>();

    @Override
    public Appointment createAppointment(Appointment appointment) {
        DB.add(new Appointment(
                appointment.getDoctor(),
                appointment.getDurationInMinutes(),
                appointment.getTime(),
                appointment.getService(),
                appointment.getLocation(),
                appointment.getId()));
        return appointment;
    }

    @Override
    public List<Appointment> getAllAppointments() {
        return DB;
    }

}
