package com.github.hirschmax.resource;

import com.github.hirschmax.model.Person;

import java.time.format.DateTimeFormatter;

public record PersonResponseBody(String id, String name, String birthdate) {
    public PersonResponseBody(Person person) {
        this(person.id(), person.name(), person.birthdate().format(DateTimeFormatter.ISO_LOCAL_DATE));
    }
}
