package vasouv.dietlogs.service;

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

}