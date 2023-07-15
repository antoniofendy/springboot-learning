package com.fendy.belajarmvc.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class HelloControllerIntegrationTest {

    @LocalServerPort
    private Integer port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void helloGuest() {
        String response = restTemplate.getForEntity("http://localhost:" + port + "/hello", String.class)
                .getBody();

        Assertions.assertNotNull(response);
        Assertions.assertEquals("Hello world Guest", response.trim());
    }

    @Test
    void helloName() {
        String response = restTemplate.getForEntity("http://localhost:" + port + "/hello?name=Fendy", String.class)
                .getBody();

        Assertions.assertNotNull(response);
        Assertions.assertEquals("Hello world Fendy", response.trim());
    }

}
