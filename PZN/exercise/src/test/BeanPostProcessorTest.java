package com.fendy.exercise;

import com.fendy.exercise.data.Car;
import com.fendy.exercise.processor.IdGeneratorBeanPostProcessor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

public class BeanPostProcessorTest {

    @Configuration
    @Import({
            Car.class,
            IdGeneratorBeanPostProcessor.class
    })
    public static class TestConfiguration{

    }

    private ConfigurableApplicationContext applicationContext;

    @BeforeEach
    void setUp() {
        applicationContext = new AnnotationConfigApplicationContext(TestConfiguration.class);
        applicationContext.registerShutdownHook();
    }

    @Test
    void testCar() {
        // with bean post processor we can modify a bean creation easily
        Car car = applicationContext.getBean(Car.class);

        System.out.println(car.getId());
        Assertions.assertNotNull(car.getId());
    }

}
