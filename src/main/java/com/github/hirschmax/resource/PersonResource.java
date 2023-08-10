package com.github.hirschmax.resource;

import com.github.hirschmax.model.PersonRecord;
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
    public PersonRecord getUserByName(String name) {
        return personService.getPersonByName(name);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/id/{id}")
    public PersonRecord getUserById(String id) {
        return personService.getPersonById(id);
    }

    @POST
    @Path("/create/{name}")
    @Transactional
    public void createPerson(String name) {
        personService.createPerson(name);
    }
}
