package vasouv.dietlogs.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;

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
@CrossOrigin(origins = "http://localhost:4200")
public class PersonController {

    @Autowired
    private PersonService personService;

    // @GetMapping
    // public ResponseEntity<?> findAll() {
    //     List<Person> all = personService.findAll();
    //     if (all.isEmpty()) {
    //         return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    //     }
    //     return new ResponseEntity<>(all, HttpStatus.OK);
    // }

    // @GetMapping("{id}")
    // public ResponseEntity<Person> findById(@PathVariable int id) {
    //     Optional<Person> found = personService.findById(id);
    //     if (!found.isPresent()) {
    //         return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    //     }
    //     return new ResponseEntity<>(found.get(), HttpStatus.OK);
    // }

    // @PostMapping
    // public ResponseEntity<Person> create(@RequestBody Person person) {
    //     Person saved = personService.create(person);
    //     return new ResponseEntity<>(saved,HttpStatus.CREATED);
    // }

    // @DeleteMapping("/{id}")
    // public void delete(@PathVariable int id) {
    //     personService.delete(id);
    // }

    @GetMapping
    public List<Person> findAll() {
        return personService.findAll();
    }

    @GetMapping("{id}")
    public Person findById(@PathVariable int id) {
        Optional<Person> found = personService.findById(id);
        return found.get();
    }

    @PostMapping
    public Person create(@RequestBody Person person) {
        return personService.create(person);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        personService.delete(id);
    }

}
