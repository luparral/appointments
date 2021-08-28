package com.sesame.appointments.api;

import com.sesame.appointments.model.AppointmentError;
import com.sesame.appointments.model.DoctorAppointment;
import com.sesame.appointments.service.AppointmentErrorService;
import com.sesame.appointments.service.AppointmentsService;
import com.sesame.appointments.service.DoctorAppointmentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("api/v1/doctor/appointments")
@RestController
public class DoctorAppointmentsController {

    @Autowired
    private final DoctorAppointmentsService doctorAppointmentsService;
    private final AppointmentsService appointmentsService;
    private final AppointmentErrorService appointmentErrorService;

    public DoctorAppointmentsController(DoctorAppointmentsService doctorAppointmentsService, AppointmentsService appointmentsService, AppointmentErrorService appointmentErrorService) {
        this.doctorAppointmentsService = doctorAppointmentsService;
        this.appointmentsService = appointmentsService;
        this.appointmentErrorService = appointmentErrorService;
    }

    @GetMapping
    public APIResponse getAll() {
        appointmentsService.loadAllFromRestService(); // load all appointments in original format
        List <AppointmentError> appointmentErrors = this.appointmentErrorService.getAppointmentErrors(); // get the appointment errors that were stored in DB after loading and parsing the input.
        List<DoctorAppointment> doctorAppointments = this.doctorAppointmentsService.getDoctorAppointments(); // Only took care of process valid appointments. It will ask for valid appointments to appointmentService
        return new APIResponse(doctorAppointments, appointmentErrors);
    }
}
