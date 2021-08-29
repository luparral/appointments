package com.sesame.appointments.dao;
import com.sesame.appointments.model.*;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository("inMemoryDrAppDao")
public class DoctorAppointmentDaoImpl implements DoctorAppointmentDao {
    private static List<DoctorAppointment> DB = new ArrayList<>();

    @Override
    public List<DoctorAppointment> getDoctorAppointments() {
        return DB.stream().collect(Collectors.toList());
    }

    public void updateDoctorAppointmentWithAppointment(DoctorAppointment doctorAppointmentToUpdate, Appointment appointment) {
        ShortAppointment shortAppointmentNewEntry = createNewShortAppointmentEntry(appointment);
        Optional<AppointmentByLocation> appointmentByLocationMaybe = selectAppointmentByLocationForLocation(doctorAppointmentToUpdate, appointment.getLocation());
        if (!appointmentByLocationMaybe.isPresent()) {
            addNewAppointmentByLocationEntry(doctorAppointmentToUpdate, appointment.getLocation(), shortAppointmentNewEntry);
        } else {
            AppointmentByLocation appointmentByLocationToUpdate = appointmentByLocationMaybe.get();
            Optional<AppointmentByLocation> updatedAppointmentByLocationEntry = addNewShortAppointmentEntry(appointmentByLocationToUpdate, shortAppointmentNewEntry);
            if(updatedAppointmentByLocationEntry.isPresent()){
                updateAnEntryInAppointmentsByLocation(doctorAppointmentToUpdate, appointmentByLocationToUpdate, updatedAppointmentByLocationEntry.get());
            }
        }
        updateDoctorAppointment(doctorAppointmentToUpdate);
    }

    private void updateAnEntryInAppointmentsByLocation(DoctorAppointment doctorAppointmentToUpdate, AppointmentByLocation appointmentByLocationToUpdate, AppointmentByLocation updatedAppointmentByLocationEntry){
        List<AppointmentByLocation> doctorAppointmentsByLocation = doctorAppointmentToUpdate.getAppointmentsByLocation();

        int indexOfAppointmentByLocationToUpdate = doctorAppointmentsByLocation.indexOf(appointmentByLocationToUpdate);
        if (indexOfAppointmentByLocationToUpdate >= 0) {
            doctorAppointmentsByLocation.set(indexOfAppointmentByLocationToUpdate, updatedAppointmentByLocationEntry);
        }
        doctorAppointmentToUpdate.setAppointmentsByLocation(doctorAppointmentsByLocation);

    }

    private Optional<AppointmentByLocation> addNewShortAppointmentEntry(AppointmentByLocation appointmentByLocationToUpdate, ShortAppointment shortAppointmentEntry) {
        List<ShortAppointment> shortAppointments = appointmentByLocationToUpdate.getAppointments();
        Optional<ShortAppointment> sameIdEntry = selectShortAppointment(shortAppointments, shortAppointmentEntry);
        if(!sameIdEntry.isPresent()){
            shortAppointments.add(shortAppointmentEntry);
            appointmentByLocationToUpdate.setAppointments(shortAppointments);
        }
        return Optional.of(appointmentByLocationToUpdate);
    }

    private Optional<ShortAppointment> selectShortAppointment(List<ShortAppointment> shortAppointments, ShortAppointment shortAppointmentEntry){
        return shortAppointments.stream()
                .filter(shortAppointment -> shortAppointment.getAppointmentId().equals(shortAppointmentEntry.getAppointmentId()))
                .findFirst();
    }

    private void addNewAppointmentByLocationEntry(DoctorAppointment doctorAppointmentToUpdate, Location location, ShortAppointment shortAppointmentNewEntry) {
        AppointmentByLocation entry = createNewLocationEntry(location, shortAppointmentNewEntry);
        List<AppointmentByLocation> appointmentsByLocation = doctorAppointmentToUpdate.getAppointmentsByLocation();
        appointmentsByLocation.add(entry);
        doctorAppointmentToUpdate.setAppointmentsByLocation(appointmentsByLocation);
    }

    public DoctorAppointment createDoctorAppointment(Appointment appointment) {
        String firstName = appointment.getDoctor().getFirstName();
        String lastName = appointment.getDoctor().getLastName();

        ShortAppointment shortAppointment = createNewShortAppointmentEntry(appointment);

        AppointmentByLocation appointmentByLocation = createNewLocationEntry(appointment.getLocation(), shortAppointment);
        List<AppointmentByLocation> appointmentsByLocation = new ArrayList<>();
        appointmentsByLocation.add(appointmentByLocation);

        return new DoctorAppointment(firstName, lastName, appointmentsByLocation);
    }

    @Override
    public void addDoctorAppointment(DoctorAppointment doctorAppointment) {
        DB.add(doctorAppointment);
    }

    private AppointmentByLocation createNewLocationEntry(Location location, ShortAppointment appointmentEntry) {
        String locationName = location.getName();
        List<ShortAppointment> appointments = new ArrayList<>();
        appointments.add(appointmentEntry);

        return new AppointmentByLocation(locationName, appointments);
    }

    private ShortAppointment createNewShortAppointmentEntry(Appointment appointment) {
        MedicalService service = appointment.getService();
        String appointmentId = appointment.getId();
        String duration = "PT" + appointment.getDurationInMinutes() + "M";
        String startDateTime = appointment.getTime();
        return new ShortAppointment(appointmentId, startDateTime, duration, service);
    }

    public Optional<DoctorAppointment> selectDoctorAppointmentsForDoctor(Doctor doctor) {
        return DB.stream()
                .filter(doctorAppointment -> doctorAppointment.getFirstName().equals(doctor.getFirstName()) && doctorAppointment.getLastName().equals(doctor.getLastName()))
                .findFirst();
    }

    private Optional<AppointmentByLocation> selectAppointmentByLocationForLocation(DoctorAppointment doctorAppointment, Location location) {
        List<AppointmentByLocation> appointmentsByLocations = doctorAppointment.getAppointmentsByLocation();
        return appointmentsByLocations.stream().filter(appointmentByLocation -> appointmentByLocation.getLocationName().equals(location.getName()))
                .findFirst();
    }

    private void updateDoctorAppointment(DoctorAppointment doctorAppointment){
        int indexOfDoctorAppointmentToUpdate = DB.indexOf(doctorAppointment);
        if (indexOfDoctorAppointmentToUpdate >= 0) {
            DB.set(indexOfDoctorAppointmentToUpdate, doctorAppointment);
        }
    }
}