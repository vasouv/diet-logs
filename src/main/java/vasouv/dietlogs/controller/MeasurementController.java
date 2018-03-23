package vasouv.dietlogs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vasouv.dietlogs.entities.Measurement;
import vasouv.dietlogs.service.MeasurementService;

/**
 *
 * @author vasouv
 */
@RestController
@RequestMapping
public class MeasurementController {

    @Autowired
    private MeasurementService measurementService;

    @GetMapping("/persons/{id}/measurements")
    public Iterable<Measurement> findMeasurements(@PathVariable int id) {
        return measurementService.findByPersonID(id);
    }

}
