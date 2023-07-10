package com.fendy.exercise;

import com.fendy.exercise.data.Connection;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class LifecycleTest {

    private ConfigurableApplicationContext applicationContext;

    @BeforeEach
    void setUp() {
        applicationContext = new AnnotationConfigApplicationContext(LifecycleConfiguration.class);
    }

    @AfterEach
    void tearDown() {
        applicationContext.close();
    }

    @Test
     void testLifecycle() {
        Connection connection = applicationContext.getBean(Connection.class);
    }

}
