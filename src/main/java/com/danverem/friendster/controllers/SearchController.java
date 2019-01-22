package com.danverem.friendster.controllers;

import com.danverem.friendster.dtos.SearchResult;
import com.danverem.friendster.services.SearchService;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("search")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Stateless
@LocalBean
public class SearchController {

    @Inject
    SearchService searchService;

    @GET
    public Response search(@QueryParam("param") String searchParam) {
        List<SearchResult> users = searchService.search(searchParam);

        return Response.ok().entity(users).build();
    }
}
