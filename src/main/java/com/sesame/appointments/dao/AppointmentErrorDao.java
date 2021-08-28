package com.sesame.appointments.dao;

import com.sesame.appointments.model.Appointment;
import com.sesame.appointments.model.AppointmentError;

import java.util.List;

public interface AppointmentErrorDao {

    List<AppointmentError> getAppointmentErrors();

    void addAppointmentError(Appointment appointment);
}
