package vasouv.dietlogs.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import vasouv.dietlogs.entities.Person;

/**
 *
 * @author vasou
 */
@Repository
public interface PersonRepository extends CrudRepository<Person, Integer> {
    
    @Query("select max(p.id) from Person p")
    int getMaxMeasurementID();
    
}
