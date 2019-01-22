package com.danverem.friendster.controllers;

import com.danverem.friendster.dtos.UserDTO;
import com.danverem.friendster.exceptions.NullNotAllowedException;
import com.danverem.friendster.services.UserService;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityNotFoundException;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;

@Stateless
@LocalBean
@Path("users")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserController {

    @Inject
    UserService userService;

    @GET
    public Response index() {
        List<UserDTO> users = userService.all();

        return Response.ok(users).build();
    }

    @POST
    public Response store(UserDTO userDTO) {
        if (userDTO == null) {
            throw new NullNotAllowedException("invalid request body");
        }

        UserDTO user = userService.save(userDTO);

        return Response.status(Response.Status.CREATED).entity(user).build();
    }


    @GET
    @Path("{id}")
    public Response find(@PathParam("id") Long ID) {
        Optional<UserDTO> user = userService.findOne(ID);

        if(!user.isPresent()) {
            throw new EntityNotFoundException("Invalid user id");
        }

        return Response.ok(user.get()).build();
    }


    @PUT
    @Path("{id}")
    public Response edit(@PathParam("id") Long ID, UserDTO userDTO) {
        Optional<UserDTO> user = userService.findOne(ID);

        if(!user.isPresent()) {
            throw new EntityNotFoundException("Invalid user id");
        }

        UserDTO updatedUser = userService.update(userDTO);

        return Response.ok(updatedUser).build();
    }

    @Path("{id}")
    @DELETE
    public Response destroy(@PathParam("id") Long ID) {
        userService.delete(ID);

        return Response.noContent().build();
    }
}
