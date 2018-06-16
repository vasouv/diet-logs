package vasouv.dietlogs.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import vasouv.dietlogs.entities.Appointment;
import vasouv.dietlogs.service.AppointmentService;
import vasouv.dietlogs.service.PersonService;

/**
 * @author vasouv
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private PersonService personService;

    @GetMapping("/appointments")
    public List<Appointment> findAllAppointments() {
        return appointmentService.findAll();
    }

    @GetMapping("/appointments/{id}")
    public Appointment findAppointmentByID(@PathVariable int id) {
        return appointmentService.findByID(id).get();

    }

    @GetMapping("/persons/{personID}/appointment")
    public Appointment findByPersonID(@PathVariable int personID) {
        return appointmentService.findByPersonID(personID).get();
    }

    @PostMapping("/persons/{personID}/appointment")
    public Appointment createAppointment(@RequestBody Appointment appointment, @PathVariable int personID) {
        LocalDate today = LocalDate.now();
        LocalDate appointmentDate = appointment.getAppointmentDate();

        if (appointmentDate.isBefore(today)) {
            // return new ResponseEntity<>("Date cannot be before today",
            // HttpStatus.NO_CONTENT);
            // throw exception
        }

        appointment.setPerson(personService.findById(personID).get());
        return appointmentService.create(appointment);
    }

    @DeleteMapping("/appointments/{id}")
    public void removeAppointment(@PathVariable int id) {
        appointmentService.remove(id);
    }

    @GetMapping("/appointmentsByDay/today")
    public List<Appointment> getTodaysAppointments() {
        return appointmentService.todaysAppointments();
    }

    @GetMapping("/appointmentsByDay/tomorrow")
    public List<Appointment> getTomorrowsAppointments() {
        return appointmentService.tomorrowsAppointments();
    }

}
