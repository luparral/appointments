package com.sesame.appointments.dao;

import com.sesame.appointments.model.Appointment;

import java.util.List;

public interface AppointmentDao {
    Appointment createAppointment(Appointment appointment);
    List<Appointment> getValidAppointments();
    List<Appointment> getInvalidAppointments();

}
