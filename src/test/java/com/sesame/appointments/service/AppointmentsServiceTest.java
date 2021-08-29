package com.sesame.appointments.service;
import com.sesame.appointments.dao.AppointmentDao;
import com.sesame.appointments.model.Appointment;
import com.sesame.appointments.model.Doctor;
import com.sesame.appointments.model.Location;
import com.sesame.appointments.model.MedicalService;
import com.sesame.appointments.util.MockGenerator;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

class AppointmentsServiceTest {


    @Mock AppointmentDao appointmentDao = Mockito.mock(AppointmentDao.class);
    @Mock AppointmentErrorService appointmentErrorService = Mockito.mock(AppointmentErrorService.class);
    @Mock RestService restService = Mockito.mock(RestService.class); ;
    MockGenerator mockGenerator = new MockGenerator();


    private final AppointmentsService appointmentsService = new AppointmentsService(appointmentDao, appointmentErrorService, restService);

    private MedicalService validService = mockGenerator.createMockService("service", 10);
    private Doctor validDoctor = mockGenerator.createMockDoctor("Bruce", "Wayne");
    private Location validLocation = mockGenerator.createMockLocation("Gotham", "America/Somewhere");
    private Appointment validAppointment = mockGenerator.createMockAppointment(validDoctor, 20, "2021-08-29 03:53:00", validService, validLocation, "1234");

    private MedicalService invalidService = mockGenerator.createMockService("service", 10);
    private Doctor invalidDoctor = mockGenerator.createMockDoctor("Bruce", "Wayne");
    private Appointment invalidAppointment = mockGenerator.createMockAppointment(invalidDoctor, 20, "2021-08-29 03:53:00", invalidService, null, "1234");

    private Appointment otherInvalidAppointment = mockGenerator.createMockAppointment(null, 20, "2021-08-29 03:53:00", null, null, "1234");

    @Test
    void createAppointments() {
        List<Appointment> appointments = new ArrayList<>();
        appointments.add(validAppointment);
        appointments.add(invalidAppointment);
        appointments.add(otherInvalidAppointment);

        appointmentsService.createAppointments(appointments);
        verify(appointmentErrorService, times(1)).addAppointmentError(invalidAppointment);
        verify(appointmentErrorService, times(1)).addAppointmentError(otherInvalidAppointment);
        verify(appointmentDao, times(0)).createAppointment(invalidAppointment);
    }


    @Test
    void getValidAppointments() {
        // TODO: implement test
        //  GIVEN an in Memory DB populates with Appointments.
        //  WHEN getValidAppointments is called
        //  THEN the Appointments in the DB are returned.
    }

    @Test
    void loadAppointmentsFromRestService() {
        // TODO: implement test
        //  GIVEN a mocked RestService that returns a JSON with N Appointments
        //        and a mocked ObjectMapped that returns an object of type List<Appointment> when readValue is called with a String object.
        //  WHEN loadAppointmentsFromRestService is called
        //  THEN the method createAppointments is called exactly 1 time with an object of type List<Appointment>.
    }
}
