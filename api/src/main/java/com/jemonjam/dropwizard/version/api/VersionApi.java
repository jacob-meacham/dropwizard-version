/*
 * Copyright 2016 Jacob Meacham (jemonjam.com).
 */

package com.jemonjam.dropwizard.version.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * API for retrieving version information about the application.
 */
@Path("/version")
@Produces(MediaType.APPLICATION_JSON)
public interface VersionApi {
    /**
     * Gets the version of the application. This is always non-null.
     * @return The version as a string
     */
    @GET
    String version();
}
