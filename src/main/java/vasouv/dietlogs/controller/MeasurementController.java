package vasouv.dietlogs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vasouv.dietlogs.entities.Measurement;
import vasouv.dietlogs.service.MeasurementService;
import vasouv.dietlogs.service.PersonService;

/**
 *
 * @author vasouv
 */
@RestController
@RequestMapping("/persons/{id}/measurements")
public class MeasurementController {

    @Autowired
    private MeasurementService measurementService;

    @Autowired
    private PersonService personService;

    @GetMapping
    public Iterable<Measurement> findMeasurements(@PathVariable int id) {
        return measurementService.findByPersonID(id);
    }

    @PostMapping
    public void addMeasurement(@RequestBody Measurement measurement, @PathVariable int id) {
        measurement.setPerson(personService.findById(id).get());
        measurementService.addMeasurement(measurement);
    }

    @DeleteMapping("/{mid}")
    public void removeMeasurement(@PathVariable int mid) {
        measurementService.removeMeasurement(mid);
    }

}
