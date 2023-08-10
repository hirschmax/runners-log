package com.github.hirschmax.service;

import com.github.hirschmax.exceptions.PersonNotFoundException;
import com.github.hirschmax.model.PersonRecord;
import com.github.hirschmax.persistence.PersonRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PersonService {

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public PersonRecord getPersonByName(String name) {
        return personRepository.findUserByName(name)
                .map(PersonRecord::new)
                .orElseThrow(() -> new PersonNotFoundException(String.format("User not found! (name = %s)", name)));
    }

    public PersonRecord getPersonById(String id) {
        return personRepository.findUserById(id)
                .map(PersonRecord::new)
                .orElseThrow(() -> new PersonNotFoundException(String.format("User not found! (id = %s)", id)));
    }

    public void createPerson(String name) {
        personRepository.createPerson(name);
    }
}
