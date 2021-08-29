package com.sesame.appointments.dao;

import org.junit.jupiter.api.Test;

class DoctorAppointmentDaoImplTest {

    @Test
    void getDoctorAppointments() {
        // TODO: implement test
        //  GIVEN a in Memory DB with Doctor Appointments
        //  WHEN getDoctorAppointments is called
        //  THEN all the Doctor Appointments in the DB are returned.
    }

    @Test
    void updateDoctorAppointmentWithAppointment() {
        // TODO: implement test
        //  GIVEN a in Memory DB with Doctor Appointments
        //  WHEN getDoctorAppointments is called
        //  THEN all the Doctor Appointments in the DB are returned.
    }

    @Test
    void createDoctorAppointment() {
        // TODO: implement test
        //  GIVEN an Appointment
        //  WHEN createDoctorAppointment is called
        //  THEN a new Doctor Appointment is created with the information provided in the Appointment
        //       this Doctor Appointment has only 1 Appointment by Location entry with the Location of the Appointment
        //                               the Appointment by Location has only 1 ShortAppointment with the appointment id of the Appointment
    }

    @Test
    void addDoctorAppointment() {
        // TODO: implement test
        //  GIVEN a Doctor Appointment and an in Memory DB
        //  WHEN addDoctorAppointment is called
        //  THEN the Doctor Appointment is added to the DB

    }

    @Test
    void selectDoctorAppointmentsForDoctor() {
        // TODO: implement test
        //  GIVEN a Doctor and an in Memory DB with a Doctor Appointment entry that has same firstName and lastName as the Doctor.
        //  WHEN selectDoctorAppointmentsForDoctor is called
        //  THEN an Optional with this Doctor Appointment is returned

        // TODO: implement test
        //  GIVEN a Doctor and an in Memory DB with a Doctor Appointment entry that has different firstName and lastName as the Doctor.
        //  WHEN selectDoctorAppointmentsForDoctor is called
        //  THEN an empty Optional is returned.

    }

}