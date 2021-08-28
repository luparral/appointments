package com.sesame.appointments.service;

import com.sesame.appointments.dao.DoctorAppointmentDao;
import com.sesame.appointments.model.Appointment;
import com.sesame.appointments.model.AppointmentError;
import com.sesame.appointments.model.DoctorAppointment;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DoctorAppointmentsService {

    private final DoctorAppointmentDao doctorAppointmentDao;
    private final AppointmentsService appointmentsService;
    private final AppointmentErrorService appointmentErrorService;

    public DoctorAppointmentsService(@Qualifier("inMemoryDrAppDao") DoctorAppointmentDao doctorAppointmentDao,
                                     AppointmentsService appointmentsService,
                                     AppointmentErrorService appointmentErrorService) {
        this.doctorAppointmentDao = doctorAppointmentDao;
        this.appointmentsService = appointmentsService;
        this.appointmentErrorService = appointmentErrorService;
    }

    public List<DoctorAppointment> getAllDoctorAppointments() {
        List<Appointment> appointments = appointmentsService.getAllAppointments();
        List<Appointment> validAppointments  = new ArrayList<>();
        appointments.forEach(appointment -> {
            if (appointment.valid()) {
                validAppointments.add(appointment);
            } else {
                appointmentErrorService.addInvalidAppointment(appointment);
            }
        });
        return doctorAppointmentDao.getAllDoctorAppointments(validAppointments);

    }

}
