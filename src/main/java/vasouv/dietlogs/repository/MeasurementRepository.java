package vasouv.dietlogs.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import vasouv.dietlogs.entities.Measurement;

/**
 *
 * @author vasou
 */
@Repository
public interface MeasurementRepository extends CrudRepository<Measurement, Integer> {

    Iterable<Measurement> findByPersonId(int id);
    
    @Query("select max(m.id) from Measurement m")
    int getMaxMeasurementID();

}
