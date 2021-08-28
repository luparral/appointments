package com.sesame.appointments.dao;

import com.sesame.appointments.model.*;
import com.sesame.appointments.service.AppointmentsService;
import org.junit.jupiter.api.Test;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class DoctorAppointmentDaoImplTest {

    private final AppointmentDao appointmentDao = new AppointmentDaoImpl();
    public final AppointmentsService appointmentsService = new AppointmentsService(appointmentDao);

    MedicalService service1 = createMockService("Psychiatry", 50);
    MedicalService service2 = createMockService("Cardiology", 45);
    ShortAppointment shortAppointment1 =  createMockShortAppointment("1234", "2021-08-25 11:06:00", "PT10M", service1);
    ShortAppointment shortAppointment2 = createMockShortAppointment("1235", "2021-08-26 11:06:00", "PT30M", service2);

    ShortAppointment shortAppointment3 =  createMockShortAppointment("1236", "2021-08-25 16:06:00", "PT10M", service1);
    ShortAppointment shortAppointment4 = createMockShortAppointment("1237", "2021-08-26 16:06:00", "PT30M", service2);


    /*AppointmentByLocation appointmentByLocation1 = createMockAppointmentByLocation()
    AppointmentByLocation appointmentByLocation2 =
    AppointmentByLocation appointmentByLocation3 =
*/

    @Test
    void testSelectAppointmentByLocationForLocation() {

    }


/*
    private Optional<AppointmentByLocation> selectAppointmentByLocationForLocation(DoctorAppointment doctorAppointment, Location location) {
        //Get the list of Appointment by Location in a doctor entry for a given location
        List<AppointmentByLocation> appointmentsByLocations = doctorAppointment.getAppointmentsByLocation();
        return appointmentsByLocations.stream().filter(appointmentByLocation -> appointmentByLocation.getLocationName().equals(location.getName()))
                .findFirst();
    }*/

    private DoctorAppointment createMockDoctorAppointment(String firstName, String lastName, List<AppointmentByLocation> appointmentByLocations){
        return new DoctorAppointment(firstName, lastName, appointmentByLocations);
    }

    private AppointmentByLocation createMockAppointmentByLocation(String locationName, List<ShortAppointment> appointments){
        return new AppointmentByLocation(locationName, appointments);
    }

    private ShortAppointment createMockShortAppointment(String id, String startDateTime, String duration, MedicalService service){
        return new ShortAppointment(id, startDateTime, duration, service);
    }

    private MedicalService createMockService(String name, int price){
        return new MedicalService(name, price);
    }


    /*
               public ShortAppointment(@JsonProperty("appointmentId") String appointmentId,
                            @JsonProperty("startDateTime") String startDateTime,
                            @JsonProperty("duration") String duration,
                            @JsonProperty("service") MedicalService service) {*/
}