package vasouv.dietlogs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vasouv.dietlogs.entities.Measurement;
import vasouv.dietlogs.repository.MeasurementRepository;

/**
 *
 * @author vasou
 */
@Service
public class MeasurementService {

    @Autowired
    private MeasurementRepository measurementRepository;

    public Iterable<Measurement> findAll() {
        return measurementRepository.findAll();
    }

    public Iterable<Measurement> findByPersonID(int id) {
        return measurementRepository.findByPersonId(id);
    }

    public void addMeasurement(Measurement measurement) {
        measurement.setId(measurementRepository.getMaxMeasurementID() + 1);
        measurementRepository.save(measurement);
    }
    
    public void removeMeasurement(int id){
        measurementRepository.deleteById(id);
    }

}
