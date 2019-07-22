package com.meetup.attendee;

import java.util.List;

import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import io.quarkus.panache.common.Sort;

@Path("/attendee")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AttendeeResource {

    @GET
    @Path( "/hello" )
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello Meetup";
    }

    @GET
    public List<Attendee> getAll() {
        return Attendee.listAll( Sort.by( "name" ) );
    }

    @GET
    @Path("{id}")
    public Attendee getSingle(@PathParam( "id" ) Long id) {
        Attendee entity = Attendee.findById(id);
        if (entity == null) {
            throw new WebApplicationException("Attendee with id of " + id + " does not exist.", 404);
        }
        return entity;
    }

    @POST
    @Transactional
    public Response create(Attendee attendee) {
        if (attendee.id != null) {
            throw new WebApplicationException("Id was invalidly set on request.", 422);
        }

        attendee.persist();
        return Response.ok(attendee).status(201).build();
    }

    @PUT
    @Path("{id}")
    @Transactional
    public Attendee update(@PathParam( "id" ) Long id, Attendee attendee) {
        if (attendee.getName() == null) {
            throw new WebApplicationException("Attendee Name was not set on request.", 422);
        }

        Attendee entity = Attendee.findById(id);
        if (entity == null) {
            throw new WebApplicationException("Attendee with id of " + id + " does not exist.", 404);
        }
        entity.setName( attendee.getName() );
        return entity;
    }

    @DELETE
    @Path("{id}")
    @Transactional
    public Response delete(@PathParam( "id" ) Long id) {
        Attendee entity = Attendee.findById(id);
        if (entity == null) {
            throw new WebApplicationException("Attendee with id of " + id + " does not exist.", 404);
        }
        entity.delete();
        return Response.status(204).build();
    }
}