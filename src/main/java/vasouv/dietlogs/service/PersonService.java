package vasouv.dietlogs.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vasouv.dietlogs.entities.Person;
import vasouv.dietlogs.repository.PersonRepository;

/**
 *
 * @author vasou
 */
@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public Iterable<Person> findAll() {
        return personRepository.findAll();
    }

    public Optional<Person> findById(int id) {
        return personRepository.findById(id);
    }

    public void createPerson(Person person) {
        person.setID(personRepository.getMaxMeasurementID() + 1);
        personRepository.save(person);
    }

}
