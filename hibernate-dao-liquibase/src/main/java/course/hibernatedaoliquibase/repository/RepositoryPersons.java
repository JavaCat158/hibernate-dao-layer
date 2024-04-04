package course.hibernatedaoliquibase.repository;

import course.hibernatedaoliquibase.entity.Persons;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RepositoryPersons {
    @PersistenceContext
    private EntityManager entityManager;

    public List<Query> getByCity(String city) {
        Query persons = entityManager.createQuery("select p from Persons p where p.city= :city", Persons.class);
        persons.setParameter("city", city);
        return persons.getResultList();
    }

    @Transactional
    public void updateTable() {
        Persons persons = Persons.builder().age(38).name("Simon").surName("Gorshkov").city("Izhevsk").phoneNumber(111111111L).build();
        entityManager.persist(persons);
    }

    public List allQuery() {
        Query query = entityManager.createQuery("select p from Persons p", Persons.class);
        return query.getResultList();
    }
}
