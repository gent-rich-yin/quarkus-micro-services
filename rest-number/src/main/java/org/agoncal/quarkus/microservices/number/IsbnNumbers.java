package org.agoncal.quarkus.microservices.number;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.json.bind.annotation.JsonbTransient;
import lombok.Data;
import lombok.NonNull;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.time.Instant;

@Data
@Schema(description = "Number REST Endpoint")
public class IsbnNumbers {
    @NonNull
    @JsonbProperty("isbn_10")
    private String isbn10;
    @NonNull
    @JsonbProperty("isbn_13")
    private String isbn13;
    @NonNull
    @JsonbTransient
    private Instant generationDate;
}
