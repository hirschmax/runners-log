package com.github.hirschmax.persistence;

import java.time.LocalDate;

public record PersonCreateParameters(String name, LocalDate birthdate) {
}
