package com.github.hirschmax.resource;

import com.github.hirschmax.service.PersonService;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/person")
public class PersonResource {

    private final PersonService personService;

    public PersonResource(PersonService personService) {
        this.personService = personService;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/name/{name}")
    public Response getUserByName(String name) {
        return Response.ok(personService.getPersonByName(name)).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/id/{id}")
    public Response getUserById(String id) {
        return Response.ok(personService.getPersonById(id)).build();
    }

    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response createPerson(PersonCreateBody personCreateBody) {
        return Response.ok(personService.createPerson(personCreateBody)).build();
    }
}
