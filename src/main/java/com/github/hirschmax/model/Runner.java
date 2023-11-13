package com.github.hirschmax.model;

import com.github.hirschmax.persistence.RunnerEntity;

import java.time.LocalDate;
import java.util.List;

public record Runner(String id, String name, LocalDate birthdate, List<Shoes> shoes) {
    public Runner(RunnerEntity runnerEntity) {
        this(runnerEntity.getId(), runnerEntity.getName(), runnerEntity.getBirthdate(), runnerEntity.getShoes().stream().map(Shoes::new).toList());
    }
}
