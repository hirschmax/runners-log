package com.github.hirschmax.model;

import com.github.hirschmax.persistence.RunnerEntity;

import java.time.LocalDate;

public record Runner(String id, String name, LocalDate birthdate) {
    public Runner(RunnerEntity runnerEntity) {
        this(runnerEntity.getId(), runnerEntity.getName(), runnerEntity.getBirthdate());
    }
}
