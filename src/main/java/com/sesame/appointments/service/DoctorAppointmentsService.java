package com.sesame.appointments.service;

import com.sesame.appointments.dao.DoctorAppointmentDao;
import com.sesame.appointments.model.Appointment;
import com.sesame.appointments.model.DoctorAppointment;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DoctorAppointmentsService {

    private final DoctorAppointmentDao doctorAppointmentDao;
    private final AppointmentsService appointmentsService;

    public DoctorAppointmentsService(@Qualifier("inMemoryDrAppDao") DoctorAppointmentDao doctorAppointmentDao,
                                     AppointmentsService appointmentsService) {
        this.doctorAppointmentDao = doctorAppointmentDao;
        this.appointmentsService = appointmentsService;
    }

    public List<DoctorAppointment> getDoctorAppointments() {
        List<Appointment> appointments = appointmentsService.getValidAppointments();
        List<Optional<DoctorAppointment>> a = processAppointment(appointments);
        return doctorAppointmentDao.getDoctorAppointments(a);
    }

    private List<Optional<DoctorAppointment>> processAppointment(List<Appointment> appointments) {
        List<Optional<DoctorAppointment>>result = new ArrayList<>();
        appointments.forEach(appointment -> {
            Optional<DoctorAppointment> doctorAppointmentMaybe = doctorAppointmentDao.selectDoctorAppointmentsForDoctor(appointment.getDoctor());
            if (!doctorAppointmentMaybe.isPresent()) {
                DoctorAppointment doctorAppointment = doctorAppointmentDao.createDoctorAppointment(appointment);
                doctorAppointmentDao.addDoctorAppointment(doctorAppointment);
                result.add(Optional.of(doctorAppointment));
            } else {
                DoctorAppointment doctorAppointmentToUpdate = doctorAppointmentMaybe.get();
                Optional<DoctorAppointment> updatedDoctorAppointment = doctorAppointmentDao.updateDoctorAppointmentWithAppointment(doctorAppointmentToUpdate, appointment);
                if(updatedDoctorAppointment.isPresent()){
                    result.add(updatedDoctorAppointment);
                }
            }
        });
        return result;
    }

}
