package org.agoncal.quarkus.microservices.book;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.time.Instant;

@Path("/api/books")
@Tag(name="Book REST Endpoint")
public class BookResource {
    @Inject
    @RestClient
    private NumberProxy numberProxy;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Fallback(fallbackMethod = "fallBackCreateABook")
    @Retry(delay = 3000L, maxRetries = 3)
    public Response createABook(
            @FormParam("title") String title,
            @FormParam("author") String author,
            @FormParam("year") int yearOfPublication,
            @FormParam("genre") String genre
    ) {
        Book book = new Book(numberProxy.generateIsbnNumbers().getIsbn13(), title, author, yearOfPublication, genre, Instant.now());
        return Response.status(Response.Status.CREATED).entity(book).build();
    }

    public Response fallBackCreateABook(
            String title,
            String author,
            int yearOfPublication,
            String genre
    ) {
        Book book = new Book("Pending", title, author, yearOfPublication, genre, Instant.now());
        return Response.status(Response.Status.PARTIAL_CONTENT).entity(book).build();
    }
}
