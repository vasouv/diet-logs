package vasouv.dietlogs.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import vasouv.dietlogs.entities.Person;

/**
 *
 * @author vasou
 */
@Repository
public interface PersonRepository extends CrudRepository<Person, Integer> {
    
}
