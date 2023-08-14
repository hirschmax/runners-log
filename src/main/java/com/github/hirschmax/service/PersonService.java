package com.github.hirschmax.service;

import com.github.hirschmax.exceptions.PersonNotFoundException;
import com.github.hirschmax.model.Person;
import com.github.hirschmax.persistence.PersonCreateParameters;
import com.github.hirschmax.persistence.PersonRepository;
import com.github.hirschmax.resource.PersonCreateBody;
import com.github.hirschmax.resource.PersonResponseBody;
import jakarta.enterprise.context.ApplicationScoped;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

@ApplicationScoped
public class PersonService {

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public PersonResponseBody getPersonByName(String name) {
        return personRepository.findUserByName(name)
                .map(Person::new)
                .map(PersonResponseBody::new)
                .orElseThrow(() -> new PersonNotFoundException(String.format("User not found! (name = %s)", name)));
    }

    public PersonResponseBody getPersonById(String id) {
        return personRepository.findUserById(id)
                .map(Person::new)
                .map(PersonResponseBody::new)
                .orElseThrow(() -> new PersonNotFoundException(String.format("User not found! (id = %s)", id)));
    }

    public void createPerson(PersonCreateBody parameters) {
        personRepository.createPerson(mapToPersonCreateParameters(parameters));
    }

    private PersonCreateParameters mapToPersonCreateParameters(PersonCreateBody inputParameters) throws DateTimeParseException {
        return new PersonCreateParameters(inputParameters.name(), LocalDate.parse(inputParameters.birthdate()));
    }
}
