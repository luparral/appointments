package com.sesame.appointments.dao;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AppointmentErrorDaoImplTest {

    @Test
    void getAppointmentErrors() {
        // TODO: implement test
        //  GIVEN an in Memory DB populated with Appointment Errors
        //  WHEN getAppointmentErrors is called
        //  THEN a list with the Appointment Errors in the DB are returned
    }

    @Test
    void addAppointmentError() {
        // TODO: implement test
        //  GIVEN an in Memory DB that has an AppointmentError with errorCode invalid_service and an Appointment that has invalid_service
        //  WHEN addAppointmentError is called
        //  THEN for the AppointmentError with error code invalid_service, the id of the Appointment is added to the ids of the AppointmentError.

        // TODO: implement test
        //  GIVEN an in Memory DB that doesn't have an AppointmentError with errorCode invalid_service and an Appointment that has invalid_service
        //  WHEN addAppointmentError is called
        //  THEN a new AppointmentError is added to the DB that has errorCode invalid_service and in its ids has the id of the Appointment.
    }
}