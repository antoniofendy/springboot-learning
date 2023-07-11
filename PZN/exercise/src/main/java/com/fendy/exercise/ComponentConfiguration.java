package com.fendy.exercise;

import com.fendy.exercise.data.MultiFoo;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = {
        "com.fendy.exercise.service",
        "com.fendy.exercise.repository",
        "com.fendy.exercise.configuration"
})
@Import(MultiFoo.class)
public class ComponentConfiguration {
}
