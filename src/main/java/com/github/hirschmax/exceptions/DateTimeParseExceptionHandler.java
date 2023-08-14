package com.github.hirschmax.exceptions;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

import java.time.format.DateTimeParseException;

@Provider
public class DateTimeParseExceptionHandler implements ExceptionMapper<DateTimeParseException> {
    @Override
    public Response toResponse(DateTimeParseException e) {
        return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
    }
}
