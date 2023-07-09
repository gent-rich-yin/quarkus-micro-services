package org.agoncal.quarkus.microservices.book;

import jakarta.json.bind.annotation.JsonbProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Isbn13 {
    @JsonbProperty("isbn_13")
    private String isbn13;
}
