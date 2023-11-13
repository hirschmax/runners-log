package com.github.hirschmax.persistence;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.Optional;

@ApplicationScoped
public class RunnerRepository implements PanacheRepository<RunnerEntity> {
    public Optional<RunnerEntity> findRunnerByName(String name) {
        return find("name", name).firstResultOptional();
    }

    public Optional<RunnerEntity> findRunnerById(String id) {
        return find("id", id).firstResultOptional();
    }

    public RunnerEntity createRunner(RunnerCreateParameters createParameters) {
        RunnerEntity entity = new RunnerEntity();
        entity.setName(createParameters.name());
        entity.setBirthdate(createParameters.birthdate());
        persist(entity);
        return entity;
    }

    public void addShoesForRunner(RunnerEntity runner, AddShoesParameters createParameters) {
        ShoesEntity entity = new ShoesEntity();
        entity.setBrand(createParameters.brand());
        entity.setLabel(createParameters.label());
        entity.setActive(createParameters.active());

        runner.getShoes().add(entity);
        entity.setRunner(runner);
        persist(runner);
    }
}
