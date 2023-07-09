package org.agoncal.quarkus.microservices.book;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;
import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

@ApplicationPath("/")
@OpenAPIDefinition(
        info=@Info(
                title = "Book API",
                description = "Create books",
                version = "1.0",
                contact = @Contact(name="Richard Yin")
        ),
        tags={
                @Tag(name = "api", description = "Public API"),
                @Tag(name = "books", description = "Interested in books")
        }
)
public class BookMicroservice extends Application {
}
