package vasouv.dietlogs.controller;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import vasouv.dietlogs.entities.Appointment;
import vasouv.dietlogs.service.AppointmentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import vasouv.dietlogs.entities.Person;
import vasouv.dietlogs.service.PersonService;

/**
 * @author vasouv
 */
@RestController
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private PersonService personService;

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

    @PostMapping("/persons/{personID}/appointment")
    public ResponseEntity<?> createAppointment(@RequestBody Appointment appointment, @PathVariable int personID) {
        LocalDate today = LocalDate.now();
        LocalDate appointmentDate = appointment.getAppointmentDate();

        if (appointmentDate.isBefore(today)) {
            return new ResponseEntity<>("Date cannot be before today", HttpStatus.NO_CONTENT);
        }

        appointment.setPerson(personService.findById(personID).get());
        appointmentService.createAppointment(appointment);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
