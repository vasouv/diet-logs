package vasouv.dietlogs.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("all")
    public Iterable<Person> findAll() {
        return personService.findAll();
    }

}
