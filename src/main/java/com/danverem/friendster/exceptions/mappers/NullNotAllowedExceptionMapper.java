package com.danverem.friendster.exceptions.mappers;

import com.danverem.friendster.exceptions.NullNotAllowedException;
import com.danverem.friendster.utils.ErrorResponse;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class NullNotAllowedExceptionMapper implements ExceptionMapper<NullNotAllowedException> {

    @Override
    public Response toResponse(NullNotAllowedException exception) {
        return Response.status(Response.Status.BAD_REQUEST).entity(new ErrorResponse(exception.getMessage())).build();
    }
}
