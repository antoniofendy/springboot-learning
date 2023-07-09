package com.fendy.exercise;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DependsOnTest {

    private ApplicationContext applicationContext;

    @BeforeEach
    void setUp() {
        applicationContext = new AnnotationConfigApplicationContext(DependsOnConfiguration.class);
    }

    @Test
    void testDependsOn() {
        // by default spring will create beans from top to bottom line of code
        // which means, normally Foo bean will be created first, then spring will create Bar bean
        // but when we use @DependsOn Bar bean annotation on Foo Bean, spring will create Bar bean before Foo bean
    }
}
