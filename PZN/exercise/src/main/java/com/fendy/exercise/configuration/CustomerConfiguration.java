package com.fendy.exercise.configuration;

import com.fendy.exercise.repository.CustomerRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class CustomerConfiguration {

    @Primary
    @Bean
    public CustomerRepository normalCustomerRepository() {
        return new CustomerRepository();
    }

    @Bean CustomerRepository premiumCustomerRepository() {
        return new CustomerRepository();
    }

}
