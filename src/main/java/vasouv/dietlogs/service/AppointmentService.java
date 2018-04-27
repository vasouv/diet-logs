package vasouv.dietlogs.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vasouv.dietlogs.entities.Appointment;
import vasouv.dietlogs.repository.AppointmentRepository;

/**
 * @author vasouv
 */
@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    public Iterable<Appointment> findAll() {
        return appointmentRepository.findAll();
    }

    public Optional<Appointment> findByID(int id) {
        return appointmentRepository.findById(id);
    }

    public Appointment findByPersonID(int id) {
        return appointmentRepository.findByPersonId(id);
    }

    public void createAppointment(Appointment appointment) {
        appointment.setId(appointmentRepository.getMaxAppointmentID() + 1);
        appointmentRepository.save(appointment);
    }

    public void removeAppointment(int id) {
        appointmentRepository.deleteById(id);
    }

    public Iterable<Appointment> todaysAppointments() {
        return appointmentsForSpecificDate(appointmentRepository.findAll(), LocalDate.now());
    }

    public Iterable<Appointment> tomorrowsAppointments() {
        return appointmentsForSpecificDate(appointmentRepository.findAll(), LocalDate.now().plusDays(1));
    }

    private List<Appointment> appointmentsForSpecificDate(Iterable<Appointment> appointments, LocalDate specificDate) {
        List<Appointment> forSpecificDate = new ArrayList();
        for (Appointment current : appointments) {
            if (current.getAppointmentDate().equals(specificDate)) {
                forSpecificDate.add(current);
            }
        }
        return forSpecificDate;
    }

}
