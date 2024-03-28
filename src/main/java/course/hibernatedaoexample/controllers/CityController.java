package course.hibernatedaoexample.controllers;

import course.hibernatedaoexample.entity.Persons;
import course.hibernatedaoexample.repository.RepositoryPersons;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CityController {


    private final RepositoryPersons personRepository;

    @Autowired
    public CityController(RepositoryPersons personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping("/persons/by-city")
    public List<Query> getPersonsByCity(@RequestParam String city) {
        return personRepository.getByCity(city);
    }

    @GetMapping("/all")
    public List<Persons> all() {
        return personRepository.allQuery();
    }
}
