package com.amazinkart;

import org.junit.Test;

import java.io.IOException;

public class RestClientTest {
    private RestClient restClient = new RestClient();

    @Test(expected = IOException.class)
    public void shouldThrowErrorIfURLIsMalformed() throws IOException {
        restClient.getDetails("malformedUrl");
    }

    @Test()
    public void shouldNotThrowAnyExceptionGivenThatCorrectURLIsPassed() throws IOException {
        restClient.getDetails("https://api.exchangeratesapi.io/latest");
    }
}