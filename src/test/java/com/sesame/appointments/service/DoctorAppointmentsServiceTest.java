package com.sesame.appointments.service;

import com.sesame.appointments.dao.AppointmentDao;
import com.sesame.appointments.dao.DoctorAppointmentDao;
import com.sesame.appointments.model.*;
import com.sesame.appointments.util.MockGenerator;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


class DoctorAppointmentsServiceTest {

    @Test
    void getDoctorAppointments() {
        // TODO: implement test
        //  GIVEN a mocked AppointmentsService that returns an object of type List<Appointment> when getValidAppointments() is called.
        //        a mocked DoctorAppointmentDao
        //  WHEN getDoctorAppointments is called
        //  THEN appointmentsService.getValidAppointments() is called exactly once.
        //       processAppointments is called exactly once with an object of type List<Appointment>
        //       doctorAppointmentDao.getDoctorAppointments() is called exactly once.
    }

    @Test
    void processAppointments() {
        // TODO: implement test
        //  GIVEN a list 2 Appointments.
        //        a mocked DoctorAppointmentDao that returns an Optional<DoctorAppointment> object every time selectDoctorAppointmentsForDoctor it's invoked.
        //  WHEN processAppointments is called
        //  THEN doctorAppointmentDao.createDoctorAppointment is called exactly twice.
        //       doctorAppointmentDao.addDoctorAppointment is called exactly twice
        //       doctorAppointmentDao.updateDoctorAppointmentWithAppointment is never called.

        // TODO: implement test
        //  GIVEN a list 2 Appointments.
        //        a mocked DoctorAppointmentDao that returns an empty Optional object every time selectDoctorAppointmentsForDoctor it's invoked.
        //  WHEN processAppointments is called
        //  THEN doctorAppointmentDao.createDoctorAppointment is never called.
        //       doctorAppointmentDao.addDoctorAppointment is never called.
        //       doctorAppointmentDao.updateDoctorAppointmentWithAppointment is called exactly twice.
    }
}
