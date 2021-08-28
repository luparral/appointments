package com.sesame.appointments.api;

import com.sesame.appointments.dao.*;
import com.sesame.appointments.model.DoctorAppointment;
import com.sesame.appointments.service.AppointmentErrorService;
import com.sesame.appointments.service.AppointmentsService;
import com.sesame.appointments.service.DoctorAppointmentsService;
import org.junit.jupiter.api.Test;

import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class DoctorAppointmentsControllerTest {

    public final DoctorAppointmentDao doctorAppointmentDao = new DoctorAppointmentDaoImpl();
    public final AppointmentErrorDao appointmentErrorDao = new AppointmentErrorDaoImpl();
    public final AppointmentDao appointmentDao = new AppointmentDaoImpl();
    public final AppointmentsService appointmentsService = new AppointmentsService(appointmentDao);
    public final AppointmentErrorService appointmentErrorService = new AppointmentErrorService(appointmentErrorDao);
    public final DoctorAppointmentsService service = new DoctorAppointmentsService(doctorAppointmentDao, appointmentsService, appointmentErrorService);

    @Test
    void getAll() {
        DoctorAppointmentsController controller = new DoctorAppointmentsController(service, appointmentsService);
        List<DoctorAppointment> response = controller.getAll();
        assertFalse (response.isEmpty());
    }
}