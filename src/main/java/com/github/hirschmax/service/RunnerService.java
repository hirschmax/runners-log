package com.github.hirschmax.service;

import com.github.hirschmax.exceptions.RunnerNotFoundException;
import com.github.hirschmax.model.Runner;
import com.github.hirschmax.persistence.RunnerCreateParameters;
import com.github.hirschmax.persistence.RunnerEntity;
import com.github.hirschmax.persistence.RunnerRepository;
import com.github.hirschmax.resource.RunnerCreateBody;
import com.github.hirschmax.resource.RunnerResponseBody;
import jakarta.enterprise.context.ApplicationScoped;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

@ApplicationScoped
public class RunnerService {

    private final RunnerRepository runnerRepository;

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

    public RunnerResponseBody createRunner(RunnerCreateBody runnerCreateBody) {
        RunnerEntity runnerEntity = runnerRepository.createRunner(mapToRunnerCreateParameters(runnerCreateBody));
        Runner runner = new Runner(runnerEntity);
        return new RunnerResponseBody(runner);
    }

    private RunnerCreateParameters mapToRunnerCreateParameters(RunnerCreateBody inputParameters) throws DateTimeParseException {
        return new RunnerCreateParameters(inputParameters.name(), LocalDate.parse(inputParameters.birthdate()));
    }
}
