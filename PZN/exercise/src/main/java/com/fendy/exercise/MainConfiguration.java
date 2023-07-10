package com.fendy.exercise;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

// with using import annotation, we can combine many configurations into single configuration
// our application context just need to use this MainConfiguration
@Configuration
@Import(value = {
        FooConfiguration.class,
        BarConfiguration.class
})
public class MainConfiguration {
}
