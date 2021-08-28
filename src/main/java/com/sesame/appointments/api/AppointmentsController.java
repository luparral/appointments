package com.sesame.appointments.api;

import com.sesame.appointments.model.Appointment;
import com.sesame.appointments.service.AppointmentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("api/v1/appointments")
@RestController
public class AppointmentsController {
    private final AppointmentsService appointmentsService;

    @Autowired
    public AppointmentsController(AppointmentsService appointmentsService) {
        this.appointmentsService = appointmentsService;
    }

    @GetMapping
    public List<Appointment> getAll() {
        return this.appointmentsService.getAllAppointments();
    }

    @PostMapping
    public void loadAllAppointments() {
        this.appointmentsService.loadAllFromFile();
    }

}
