package com.github.hirschmax.persistence;

import java.time.LocalDate;

public record RunnerCreateParameters(String name, LocalDate birthdate) {
}
