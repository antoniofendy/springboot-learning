package com.fendy.exercise;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {
        "com.fendy.exercise.service",
        "com.fendy.exercise.repository",
        "com.fendy.exercise.configuration"
})
public class ComponentConfiguration {
}
