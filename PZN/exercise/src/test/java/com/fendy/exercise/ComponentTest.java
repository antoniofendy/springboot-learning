package com.fendy.exercise;

import com.fendy.exercise.service.ProducService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ComponentTest {

    private ConfigurableApplicationContext applicationContext;

    @BeforeEach
    void setUp() {
        applicationContext = new AnnotationConfigApplicationContext(ComponentConfiguration.class);
        applicationContext.registerShutdownHook();
    }

    @Test
    void testComponent() {
        ProducService producService = applicationContext.getBean(ProducService.class);
        ProducService producService2 = applicationContext.getBean("productService", ProducService.class);
        Assertions.assertSame(producService, producService2);
    }

}
