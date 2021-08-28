package com.sesame.appointments.service;

import com.sesame.appointments.dao.AppointmentErrorDao;
import com.sesame.appointments.model.Appointment;
import com.sesame.appointments.model.AppointmentError;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentErrorService {

    private AppointmentErrorDao appointmentErrorDao;

    public AppointmentErrorService(@Qualifier("inMemoryAppointmentErrorDao") AppointmentErrorDao appointmentErrorDao) {
        this.appointmentErrorDao = appointmentErrorDao;
    }

    public List<AppointmentError> getAllAppointmentErrors() {
        return appointmentErrorDao.getAllAppointmentErrors();
    }

    public void addInvalidAppointment(Appointment appointment) {
        appointmentErrorDao.addInvalidAppointment(appointment);
    }
}
