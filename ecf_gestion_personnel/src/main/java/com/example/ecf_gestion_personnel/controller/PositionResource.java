package com.example.ecf_gestion_personnel.controller;

import com.example.ecf_gestion_personnel.model.Position;
import com.example.ecf_gestion_personnel.service.PositionService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/positions")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PositionResource {

    private final PositionService positionService;

    @Inject
    public PositionResource(PositionService positionService) {
        this.positionService = positionService;
    }

    @GET
    public List<Position> getPositions() {
        return positionService.getAllPositions();
    }

    @POST
    public Response addPosition(Position position) {
        Position pos = positionService.createPosition(position);
        return Response.status(Response.Status.CREATED).entity(pos).build();
    }

    @GET
    @Path("/{id}")
    public Position getPosition(@PathParam("id") int id) {
        return positionService.getPositionById(id);
    }

    @PUT
    @Path("/{id}")
    public Response updatePosition(@PathParam("id") int id, Position position) {
        position = positionService.updatePosition(id, position);
        return Response.status(Response.Status.OK).entity(position).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deletePosition(@PathParam("id") int id) {
        positionService.deletePosition(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

}
