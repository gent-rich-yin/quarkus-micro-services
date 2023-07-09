package org.agoncal.quarkus.microservices.book;

import io.quarkus.test.Mock;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@RestClient
@Mock
public class MockNumberProxy implements NumberProxy {
    @Override
    public Isbn13 generateIsbnNumbers() {
        return new Isbn13("13-12345678");
    }
}
