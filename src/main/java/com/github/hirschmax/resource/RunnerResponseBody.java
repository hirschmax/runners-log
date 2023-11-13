package com.github.hirschmax.resource;

import com.github.hirschmax.model.Runner;

import java.time.format.DateTimeFormatter;

public record RunnerResponseBody(String id, String name, String birthdate) {
    public RunnerResponseBody(Runner runner) {
        this(runner.id(), runner.name(), runner.birthdate().format(DateTimeFormatter.ISO_LOCAL_DATE));
    }
}
