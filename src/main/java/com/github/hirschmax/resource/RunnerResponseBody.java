package com.github.hirschmax.resource;

import com.github.hirschmax.model.Runner;
import com.github.hirschmax.model.Shoes;

import java.time.format.DateTimeFormatter;
import java.util.List;

public record RunnerResponseBody(String id, String name, String birthdate, List<Shoes> shoes) {
    public RunnerResponseBody(Runner runner) {
        this(runner.id(), runner.name(), runner.birthdate().format(DateTimeFormatter.ISO_LOCAL_DATE), runner.shoes());
    }
}
