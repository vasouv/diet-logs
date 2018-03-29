package vasouv.dietlogs.controller;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vasouv.dietlogs.entities.Person;
import vasouv.dietlogs.service.PersonService;

/**
 *
 * @author vasou
 */
@RestController
@RequestMapping("persons")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping
    public Iterable<Person> findAll() {
        return personService.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<Person> findById(@PathVariable int id) {
        Optional<Person> found = personService.findById(id);
        if (found.isPresent()) {
            return new ResponseEntity<>(found.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    
    @PostMapping
    public void createPerson(@RequestBody Person person) {
        personService.createPerson(person);
    }
    

}
