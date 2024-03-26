package course.hibernatedaoexample.repository;

import course.hibernatedaoexample.entity.Persons;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RepositoryPersons {
    @PersistenceContext
    EntityManager entityManager;

    public List<Query> getByCity(String city) {
        Query persons = entityManager.createQuery("select p from Persons p where p.city_of_living= :city", Persons.class);
        persons.setParameter("city", city);
        return persons.getResultList();
    }

    @Transactional
    public void updateTable() {
        Persons persons = Persons.builder().age(38).name("Simon").surname("Gorshkov").city_of_living("Izhevsk").phone_number(111111111).build();
        entityManager.persist(persons);
    }

    public List<Persons> allQuery() {
        Query query = entityManager.createQuery("select p from Persons p");
        return query.getResultList();
    }
}
