package com.fendy.exercise;

import com.fendy.exercise.data.Car;
import com.fendy.exercise.processor.IdGeneratorBeanPostProcessor;
import com.fendy.exercise.processor.PrefixIdGeneratorBeanPostProcessor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

public class OrderedTest {

    @Configuration
    @Import({
            Car.class,
            IdGeneratorBeanPostProcessor.class,
            PrefixIdGeneratorBeanPostProcessor.class
    })
    public static class TestConfiguration {

    }

    private ConfigurableApplicationContext applicationContext;

    @BeforeEach
    void setUp() {
        applicationContext = new AnnotationConfigApplicationContext(TestConfiguration.class);
        applicationContext.registerShutdownHook();
    }

    @Test
    void testOrdered() {
        Car car = applicationContext.getBean(Car.class);

        // because we implement Ordered interface
        // in IdGeneratorBeanPostProcessor as order 1 and PrefixIdGeneratorBeanPostProcessor as order 2
        // we can see IdGeneratorBeanPostProcessor executed before PrefixIdGeneratorBeanPostProcessor

        Assertions.assertNotNull(car.getId());
        Assertions.assertTrue(car.getId().startsWith("Fendy-"));
    }
}
