package vasouv.dietlogs.service;

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

}
