package com.github.hirschmax.exceptions;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class PersonNotFoundExceptionHandler implements ExceptionMapper<PersonNotFoundException> {
    @Override
    public Response toResponse(PersonNotFoundException e) {
        return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
    }
}
