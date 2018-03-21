package vasouv.dietlogs.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import vasouv.dietlogs.entities.Measurement;

/**
 *
 * @author vasou
 */
@Repository
public interface MeasurementRepository extends CrudRepository<Measurement, Integer> {
    
}
