package com.fendy.exercise;

import com.fendy.exercise.client.PaymentGatewayClient;
import com.fendy.exercise.factory.PaymentGatewayClientFactoryBean;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

public class FactoryBeanTest {

    private ConfigurableApplicationContext applicationContext;

    @BeforeEach
    void setUp() {
        applicationContext = new AnnotationConfigApplicationContext(FactoryBeanConfiguration.class);
        applicationContext.registerShutdownHook();
    }

    @Test
    void testFactoryBean() {
        PaymentGatewayClient paymentGatewayClient = applicationContext.getBean(PaymentGatewayClient.class);

        Assertions.assertNotNull(paymentGatewayClient);
        Assertions.assertEquals("https://example.com", paymentGatewayClient.getEndpoint());
        Assertions.assertEquals("public", paymentGatewayClient.getPublicKey());
        Assertions.assertEquals("private", paymentGatewayClient.getPrivateKey());
    }

}
