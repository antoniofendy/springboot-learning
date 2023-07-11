package com.fendy.exercise;

import com.fendy.exercise.service.MerchantService;
import com.fendy.exercise.service.MerchantServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class InheritanceTest {

    private ConfigurableApplicationContext applicationContext;

    @BeforeEach
    void setUp() {
        applicationContext = new AnnotationConfigApplicationContext(InheritanceConfiguration.class);
        applicationContext.registerShutdownHook();
    }

    @Test
    void testInheritance() {

        // in a spring project, we are going to face many of this case
        // when we are accessing a bean, we also could access its parent/interface class
        // but we need to look at the dependency used by its parent, there is a possibility of error duplicate
        MerchantService merchantService = applicationContext.getBean(MerchantService.class);
        MerchantServiceImpl merchantServiceImpl = applicationContext.getBean(MerchantServiceImpl.class);

        // Interface class has same value like its implementation class
        Assertions.assertSame(merchantService, merchantServiceImpl);

        // why we are going to face many of this case?
        // mostly spring programmer using its implementation class rather than its implementation class
        // we can modify its implementation class without modify its interface class,
        // with this option we can minimize the possibility of error duplication
    }

}
