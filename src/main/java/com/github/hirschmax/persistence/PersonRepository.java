package com.github.hirschmax.persistence;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.Optional;

@ApplicationScoped
public class PersonRepository implements PanacheRepository<PersonEntity> {
    public Optional<PersonEntity> findUserByName(String name) {
        return find("name", name).firstResultOptional();
    }

    public Optional<PersonEntity> findUserById(String id) {
        return find("id", id).firstResultOptional();
    }

    public void createPerson(PersonCreateParameters createParameters) {
        PersonEntity entity = new PersonEntity();
        entity.setName(createParameters.name());
        entity.setBirthdate(createParameters.birthdate());
        persist(entity);
    }
}
