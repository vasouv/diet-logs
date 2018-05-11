package vasouv.dietlogs.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import vasouv.dietlogs.entities.Measurement;

/**
 *
 * @author vasou
 */
@Repository
public interface MeasurementRepository extends JpaRepository<Measurement, Integer> {

    //Finds all measurements belonging to a person, duh
    List<Measurement> findByPersonId(int id);

    @Query("select coalesce(max(m.id),0) from Measurement m")
    int getMaxMeasurementID();

}
