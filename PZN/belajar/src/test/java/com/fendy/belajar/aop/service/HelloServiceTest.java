package com.fendy.belajar.aop.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class HelloServiceTest {

    @Autowired
    private HelloService helloService;

    @Test
    void testHelloService() {
        Assertions.assertEquals("Hello Fendy", helloService.hello("Fendy"));
        Assertions.assertEquals("Bye Fendy", helloService.bye("Fendy"));
    }

}
