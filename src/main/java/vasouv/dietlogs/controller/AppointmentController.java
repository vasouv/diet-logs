package vasouv.dietlogs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vasouv.dietlogs.entities.Appointment;
import vasouv.dietlogs.service.AppointmentService;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author vasouv
 */
@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @GetMapping
    public Iterable<Appointment> findAllAppointments() {
        return appointmentService.findAll();
    }

}