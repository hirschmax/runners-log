package com.github.hirschmax.model;

import com.github.hirschmax.persistence.PersonEntity;

import java.time.LocalDate;

public record Person(String id, String name, LocalDate birthdate) {
    public Person(PersonEntity personEntity) {
        this(personEntity.getId(), personEntity.getName(), personEntity.getBirthdate());
    }
}
