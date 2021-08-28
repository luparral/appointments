package com.sesame.appointments.dao;

import com.sesame.appointments.model.Appointment;
import com.sesame.appointments.model.AppointmentError;
import org.springframework.stereotype.Repository;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository("inMemoryAppointmentErrorDao")
public class AppointmentErrorDaoImpl implements AppointmentErrorDao {

    private static HashMap<String, List<String>> DB = new HashMap<>();

    @Override
    public List<AppointmentError> getAllAppointmentErrors() {
        List<AppointmentError> result = new ArrayList<>();
        DB.entrySet().stream().forEach(entry -> {
            AppointmentError error = new AppointmentError(entry.getKey(), entry.getValue());
            result.add(error);
        });
        return result;
    }

    @Override
    public void addInvalidAppointment(Appointment appointment) {
        List<String> errorCodes = appointment.getErrors();
        errorCodes.forEach(error -> {
            List<String> ids;
            if (DB.containsKey(error)){
               ids = DB.get(error);
            } else {
               ids = new ArrayList<>();
            }
            ids.add(appointment.getId());
            DB.put(error, ids);
        });
    }


}
