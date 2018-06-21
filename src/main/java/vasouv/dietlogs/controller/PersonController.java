package vasouv.dietlogs.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
 * @author vasouv
 */
@RestController
@RequestMapping("persons")
@CrossOrigin(origins = "http://localhost:4200")
public class PersonController {

    @Autowired
    private PersonService personService;

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

    @GetMapping("count")
    public int count() {
        return personService.count();
    }

}
