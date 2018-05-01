package vasouv.dietlogs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import vasouv.dietlogs.entities.Person;

/**
 *
 * @author vasou
 */
@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {
    
    @Query("select max(p.id) from Person p")
    int getMaxMeasurementID();
    
}
