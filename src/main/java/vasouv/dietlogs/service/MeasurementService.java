package vasouv.dietlogs.service;

import java.util.List;
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
    
    @Autowired
    private BMICalculator bMICalculator;

    public List<Measurement> findAll() {
        return measurementRepository.findAll();
    }

    public List<Measurement> findByPersonID(int id) {
        return measurementRepository.findByPersonId(id);
    }

    public void add(Measurement measurement) {
        measurement.setId(measurementRepository.getMaxMeasurementID() + 1);
        measurement.setBmi(bMICalculator.calculate(measurement.getWeightkg(), measurement.getPerson().getHeight()));
        measurementRepository.save(measurement);
    }
    
    public void remove(int id){
        measurementRepository.deleteById(id);
    }

}
