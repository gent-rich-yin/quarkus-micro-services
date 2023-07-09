package org.agoncal.quarkus.microservices.book;

import java.time.Instant;

import jakarta.json.bind.annotation.JsonbDateFormat;
import jakarta.json.bind.annotation.JsonbProperty;
import lombok.Data;
import lombok.NonNull;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Data
@Schema(description="A Book")
public class Book {
    @NonNull
    @JsonbProperty("isbn_13")
    private String isbn13;
    @NonNull
    private String title;
    @NonNull
    private String author;
    @NonNull
    @JsonbProperty("year_of_publication")
    private int yearOfPublication;
    @NonNull
    private String genre;
    @NonNull
    @JsonbDateFormat("yyyy/MM/dd")
    @JsonbProperty("creation_date")
    @Schema(implementation = String.class, format = "date")
    private Instant creationDate;
}
