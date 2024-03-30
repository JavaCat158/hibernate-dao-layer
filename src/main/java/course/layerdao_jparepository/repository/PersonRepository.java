package course.layerdao_jparepository.repository;

import course.layerdao_jparepository.entity.Person;
import course.layerdao_jparepository.entity.PrimaryKeyPerson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, PrimaryKeyPerson> {
    public Person findByCity(String city);
    List<Person> findByIdAgeLessThanOrderByIdAgeAsc(Integer age);
    Optional<Person> findByIdNameAndIdSurname(String name, String surname);
}
