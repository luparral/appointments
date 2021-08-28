package com.sesame.appointments.dao;

import com.sesame.appointments.model.Appointment;
import com.sesame.appointments.model.DoctorAppointment;

import java.util.List;

public interface DoctorAppointmentDao {
    List<DoctorAppointment> getAllDoctorAppointments(List<Appointment> appointments);
}
