package com.github.hirschmax.resource;

import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.TestProfile;
import io.restassured.http.ContentType;
import jakarta.ws.rs.core.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;

@QuarkusTest
class PersonResourceTest {

    @Test
    @DisplayName("Should create new person")
    void shouldCreateNewPerson() {
        PersonCreateBody jonDoe = new PersonCreateBody("Jon Doe", LocalDate.of(2000, 1, 1).toString());
        given().body(jonDoe).contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .when()
                .post("/person/create")
                .then()
                .body("name", is("Jon Doe"), "birthdate", is("2000-01-01"), "id", notNullValue())
                .statusCode(Response.Status.OK.getStatusCode());
    }
}