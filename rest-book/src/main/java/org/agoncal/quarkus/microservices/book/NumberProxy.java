package org.agoncal.quarkus.microservices.book;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient(configKey="number.proxy")
public interface NumberProxy {
    @GET
    @Path("/api/numbers")
    @Produces(MediaType.APPLICATION_JSON)
    Isbn13 generateIsbnNumbers();
}
