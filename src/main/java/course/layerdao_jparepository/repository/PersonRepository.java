package course.layerdao_jparepository.repository;

import course.layerdao_jparepository.entity.Person;
import course.layerdao_jparepository.entity.PrimaryKeyPerson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, PrimaryKeyPerson> {
    @Query("select p from Person p where p.city = :city")
    List<Person> findQueryByCity(@Param("city") String city);

    @Query("select p from Person p where p.id.age < :age  order by p.id.age desc")
    List<Person> findQueryByIdAgeLessThanOrderByIdAgeAsc(@Param("age") Integer age);

    @Query("select p from Person p where p.id.name = :name and p.id.surname = :surname")
    Optional<Person> findQueryByIdNameAndIdSurname(@Param("name") String name,@Param("surname") String surname);
}
