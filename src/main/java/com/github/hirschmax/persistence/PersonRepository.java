package com.github.hirschmax.persistence;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.Optional;

@ApplicationScoped
public class PersonRepository implements PanacheRepository<Person> {
    public Optional<Person> findUserByName(String name) {
        return find("name", name).firstResultOptional();
    }

    public Optional<Person> findUserById(String id) {
        return find("id", id).firstResultOptional();
    }

    public void createPerson(String name) {
        Person entity = new Person();
        entity.setName(name);
        persist(entity);
    }
}
