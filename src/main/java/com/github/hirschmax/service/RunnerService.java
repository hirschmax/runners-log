package com.github.hirschmax.service;

import com.github.hirschmax.exceptions.RunnerNotFoundException;
import com.github.hirschmax.model.Runner;
import com.github.hirschmax.persistence.*;
import com.github.hirschmax.resource.AddShoesBody;
import com.github.hirschmax.resource.RunnerCreateBody;
import com.github.hirschmax.resource.RunnerResponseBody;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

@ApplicationScoped
public class RunnerService {

    private final RunnerRepository runnerRepository;

    @Inject
    public RunnerService(RunnerRepository runnerRepository) {
        this.runnerRepository = runnerRepository;
    }

    public RunnerResponseBody getRunnerByName(String name) {
        return runnerRepository.findRunnerByName(name)
                .map(Runner::new)
                .map(RunnerResponseBody::new)
                .orElseThrow(() -> new RunnerNotFoundException(String.format("Runner not found! (name = %s)", name)));
    }

    public RunnerResponseBody getRunnerById(String id) {
        return runnerRepository.findRunnerById(id)
                .map(Runner::new)
                .map(RunnerResponseBody::new)
                .orElseThrow(() -> new RunnerNotFoundException(String.format("Runner not found! (id = %s)", id)));
    }

    @Transactional(rollbackOn={SQLException.class, IOException.class}, dontRollbackOn={IllegalStateException.class})
    public RunnerResponseBody createRunner(RunnerCreateBody runnerCreateBody) {
        RunnerEntity runnerEntity = runnerRepository.createRunner(mapToRunnerCreateParameters(runnerCreateBody));
        Runner runner = new Runner(runnerEntity);
        return new RunnerResponseBody(runner);
    }

    private RunnerCreateParameters mapToRunnerCreateParameters(RunnerCreateBody inputParameters) throws DateTimeParseException {
        return new RunnerCreateParameters(inputParameters.name(), LocalDate.parse(inputParameters.birthdate()));
    }

    @Transactional(rollbackOn={SQLException.class, IOException.class}, dontRollbackOn={IllegalStateException.class})
    public RunnerResponseBody addShoes(AddShoesBody addShoesBody) {
        String runnerId = addShoesBody.runnerId();
        RunnerEntity runnerEntity = runnerRepository.findRunnerById(runnerId).orElseThrow(() -> new RunnerNotFoundException(String.format("Runner not found! (id = %s)", runnerId)));
        runnerRepository.addShoesForRunner(runnerEntity, new AddShoesParameters(addShoesBody.brand(), addShoesBody.label(), addShoesBody.active()));
        return getRunnerById(runnerId);
    }
}
