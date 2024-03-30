package course.layerdao_jparepository.controller;

import course.layerdao_jparepository.entity.Person;
import course.layerdao_jparepository.entity.PrimaryKeyPerson;
import course.layerdao_jparepository.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonControllerJpa {

    private final PersonRepository personRepository;

    @Autowired
    public PersonControllerJpa(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    // Create
    @PostMapping
    public Person createPerson(@RequestBody Person person) {
        personRepository.save(person);
        return person;
    }

    // Read
    @GetMapping("/persons")
    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    @GetMapping("/persons/id")
    public List<Person> getPersonById(@RequestParam String name, @RequestParam String surname, @RequestParam int age) {
        PrimaryKeyPerson id = PrimaryKeyPerson.builder().name(name).surname(surname).age(age).build();
        return personRepository.findById(id).stream().toList();
    }

    // Update
    @PutMapping("/update")
    public ResponseEntity<Person> updatePerson(@RequestParam String name, @RequestParam String surname, @RequestParam int age, @RequestParam int phone_number, @RequestParam String city) {
        PrimaryKeyPerson id = new PrimaryKeyPerson(name, surname, age);
        personRepository.findById(id).map(person -> {
            person.setCity(city);
            person.setPhone_number(phone_number);
            return ResponseEntity.ok().body(personRepository.save(person));

        });
        return ResponseEntity.ok(personRepository.getById(id));
    }

    // Delete
    @DeleteMapping("/delete")
    public ResponseEntity<Void> deletePerson(@RequestParam String name,
                                             @RequestParam String surname,
                                             @RequestParam int age) {
        PrimaryKeyPerson id = new PrimaryKeyPerson(name, surname, age);
        personRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/city")
    public Person getByCity(@RequestParam String city) {
        return personRepository.findByCity(city);
    }

    @GetMapping("/age")
    public List<Person> getByAge(@RequestParam Integer age) {
        return personRepository.findByIdAgeLessThanOrderByIdAgeAsc(age);
    }

    @GetMapping("/findNameSurname")
    public List<Person> getNameSurname(@RequestParam String name, @RequestParam String surname) {
        return personRepository.findByIdNameAndIdSurname(name, surname).stream().toList();
    }
}