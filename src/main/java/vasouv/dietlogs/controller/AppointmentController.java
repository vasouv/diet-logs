package vasouv.dietlogs.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import vasouv.dietlogs.entities.Appointment;
import vasouv.dietlogs.service.AppointmentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author vasouv
 */
@RestController
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @GetMapping
    public Iterable<Appointment> findAllAppointments() {
        return appointmentService.findAll();
    }

    @GetMapping("/appointments/{id}")
    public ResponseEntity<Appointment> findAppointmentByID(@PathVariable int id) {
        Optional<Appointment> found = appointmentService.findByID(id);
        if (found.isPresent()) {
            return new ResponseEntity<>(found.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/persons/{personID}/appointment")
    public ResponseEntity<Appointment> findByPersonID(@PathVariable int personID) {
        Appointment found = appointmentService.findByPersonID(personID);
        return new ResponseEntity<>(found, HttpStatus.OK);
    }

}