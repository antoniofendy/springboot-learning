package com.fendy.exercise;

import com.fendy.exercise.data.Foo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ScopeTest {

    private ApplicationContext applicationContext;

    @BeforeEach
    void setUp() {
        applicationContext = new AnnotationConfigApplicationContext(ScopeConfiguration.class);
    }

    @Test
    void testPrototypeScope() {
        // Bean object that scoped as prototype
        // will be created everytime it accessed
        Foo fooFirst = applicationContext.getBean(Foo.class);
        Foo fooSecond = applicationContext.getBean(Foo.class);
        Foo fooThird = applicationContext.getBean(Foo.class);

        Assertions.assertNotSame(fooFirst, fooSecond);
        Assertions.assertNotSame(fooSecond, fooThird);
        Assertions.assertNotSame(fooFirst, fooThird);
    }

}
