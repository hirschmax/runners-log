package com.github.hirschmax.resource;

import com.github.hirschmax.service.PersonService;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/person")
public class PersonResource {

    private final PersonService personService;

    public PersonResource(PersonService personService) {
        this.personService = personService;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/name/{name}")
    public PersonResponseBody getUserByName(String name) {
        return personService.getPersonByName(name);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/id/{id}")
    public PersonResponseBody getUserById(String id) {
        return personService.getPersonById(id);
    }

    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public void createPerson(PersonCreateBody personCreateBody) {
        personService.createPerson(personCreateBody);
    }
}
