package com.github.hirschmax.resource;

import io.quarkus.test.junit.QuarkusTestProfile;

import java.util.Map;

public class LocalTestProfile implements QuarkusTestProfile {

    @Override
    public Map<String, String> getConfigOverrides() {
        return Map.of(
                "quarkus.datasource.db-kind", "h2",
                "quarkus.datasource.username", "admin",
                "quarkus.datasource.password", "admin",
                "quarkus.datasource.jdbc.url", "jdbc:h2:mem:default"
                );
    }
}
