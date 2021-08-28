package com.sesame.appointments.service;

import com.sesame.appointments.dao.AppointmentDao;
import com.sesame.appointments.dao.AppointmentDaoImpl;
import com.sesame.appointments.model.Appointment;
import com.sesame.appointments.model.Doctor;
import com.sesame.appointments.model.Location;
import com.sesame.appointments.model.MedicalService;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;

import java.io.FileReader;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class AppointmentsServiceTest {

  /*  private final AppointmentDao appointmentDao = new AppointmentDaoImpl();
    public final AppointmentsService appointmentsService = new AppointmentsService(appointmentDao);

    @Test
    void testParseJsonAppointment() throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        Object obj  = parser.parse(new FileReader("./data_test.json"));
        JSONArray jsonArray = (JSONArray) obj;
        JSONObject e = (JSONObject)jsonArray.get(0);
        Appointment parsedAppointment = appointmentsService.createAppointment(e);

        Doctor doctor = new Doctor("Bruce", "Wayne");
        int duration = 10;
        String time = "2021-08-27 11:09:00";
        MedicalService service = new MedicalService("Physiotherapy consultation", 50);
        Location location = new Location("Gotham", "America/Somewhere");
        String id = "72842fe1-3e6b-4139-b7d6-319e4efeb8cf";

        Appointment appointment = new Appointment(doctor, duration, time, service, location, id);

        assertEquals(appointment.getDoctor().getFirstName(), parsedAppointment.getDoctor().getFirstName());
        assertEquals(appointment.getDoctor().getLastName(), parsedAppointment.getDoctor().getLastName());
        assertEquals(appointment.getDurationInMinutes(), parsedAppointment.getDurationInMinutes());
        assertEquals(appointment.getTime(), parsedAppointment.getTime());
        assertEquals(appointment.getService().getName(), parsedAppointment.getService().getName());
        assertEquals(appointment.getService().getPrice(), parsedAppointment.getService().getPrice());
        assertEquals(appointment.getLocation().getName(), parsedAppointment.getLocation().getName());
        assertEquals(appointment.getLocation().getTimeZoneCode(), parsedAppointment.getLocation().getTimeZoneCode());
        assertEquals(appointment.getId(), parsedAppointment.getId());

    }
*/


}