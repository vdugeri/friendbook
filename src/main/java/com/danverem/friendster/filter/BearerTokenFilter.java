package com.danverem.friendster.filter;

import com.auth0.jwt.exceptions.JWTVerificationException;
import com.danverem.friendster.utils.JWTTokenGenerator;

import javax.annotation.Priority;
import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

@Provider
@TokenRequired
@Priority(Priorities.AUTHENTICATION)
public class BearerTokenFilter implements ContainerRequestFilter {

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        String authHeader = requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);

        if (authHeader == null) {
            throw new NotAuthorizedException("Bearer");
        }

        String token = parseToken(authHeader);

        if (!verifyToken(token)) {
            throw new NotAuthorizedException("Invalid bearer token");
        }
    }

    private String parseToken(String header) {
        return header.substring("Bearer ".length()).trim();
    }

    private boolean verifyToken(String token) {
        try {
            JWTTokenGenerator tokenGenerator = new JWTTokenGenerator();
            tokenGenerator.verifyToken(token);

            return true;
        } catch (JWTVerificationException e) {
            return false;
        }
    }
}
