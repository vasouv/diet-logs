package vasouv.dietlogs.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> findMeasurements(@PathVariable int id) {
        List<Measurement> personsMeasurements = measurementService.findByPersonID(id);
        if (personsMeasurements.isEmpty()) {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(personsMeasurements, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity addMeasurement(@RequestBody Measurement measurement, @PathVariable int id) {
        measurement.setPerson(personService.findById(id).get());
        measurementService.add(measurement);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @DeleteMapping("/{mid}")
    public void removeMeasurement(@PathVariable int mid) {
        measurementService.remove(mid);
    }

}
