package com.sesame.appointments.api;

import com.sesame.appointments.model.DoctorAppointment;
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

    public DoctorAppointmentsController(DoctorAppointmentsService doctorAppointmentsService, AppointmentsService appointmentsService) {
        this.doctorAppointmentsService = doctorAppointmentsService;
        this.appointmentsService = appointmentsService;
    }

    @GetMapping
    public List<DoctorAppointment> getAll() {
        appointmentsService.loadAllFromFile(); // load all appointments in original format
        return this.doctorAppointmentsService.getAllDoctorAppointments();
    }
}
