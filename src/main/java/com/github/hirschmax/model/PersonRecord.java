package com.github.hirschmax.model;

import com.github.hirschmax.persistence.Person;

public record PersonRecord(String id, String name) {
    public PersonRecord(Person person) {
        this(person.getId(), person.getName());
    }
}
