package com.github.hirschmax.resource;

import com.github.hirschmax.service.RunnerService;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/runner")
public class RunnerResource {

    private final RunnerService runnerService;

    public RunnerResource(RunnerService runnerService) {
        this.runnerService = runnerService;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/name/{name}")
    public Response getRunnerByName(String name) {
        return Response.ok(runnerService.getRunnerByName(name)).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/id/{id}")
    public Response getRunnerById(String id) {
        return Response.ok(runnerService.getRunnerById(id)).build();
    }

    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response createRunner(RunnerCreateBody runnerCreateBody) {
        return Response.ok(runnerService.createRunner(runnerCreateBody)).build();
    }
}
