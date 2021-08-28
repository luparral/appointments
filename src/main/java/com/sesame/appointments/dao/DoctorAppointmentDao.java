package com.sesame.appointments.dao;

import com.sesame.appointments.model.Appointment;
import com.sesame.appointments.model.Doctor;
import com.sesame.appointments.model.DoctorAppointment;

import java.util.List;
import java.util.Optional;

public interface DoctorAppointmentDao {
    List<DoctorAppointment> getDoctorAppointments();

    Optional<DoctorAppointment> selectDoctorAppointmentsForDoctor(Doctor doctor);

    DoctorAppointment createDoctorAppointment(Appointment appointment);

    void addDoctorAppointment(DoctorAppointment doctorAppointment);

    void updateDoctorAppointmentWithAppointment(DoctorAppointment doctorAppointmentToUpdate, Appointment appointment);
}
