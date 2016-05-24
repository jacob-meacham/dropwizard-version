/*
 * Copyright 2016 Jacob Meacham (jemonjam.com).
 */

package com.jemonjam.dropwizard.version.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/version")
@Produces(MediaType.APPLICATION_JSON)
public interface VersionApi {
    @GET
    String version();
}
