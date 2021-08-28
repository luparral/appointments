package com.sesame.appointments.api;

import com.sesame.appointments.model.AppointmentError;
import com.sesame.appointments.service.AppointmentErrorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("api/v1/error/appointments")
@RestController
public class AppointmentErrorController {

    @Autowired
    private AppointmentErrorService appointmentErrorService;

    public AppointmentErrorController(AppointmentErrorService appointmentErrorService) {
        this.appointmentErrorService = appointmentErrorService;
    }

    @GetMapping
    public List<AppointmentError> getAll() {
        return this.appointmentErrorService.getAppointmentErrors();
    }

}
