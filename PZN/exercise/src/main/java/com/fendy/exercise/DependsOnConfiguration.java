package com.fendy.exercise;

import com.fendy.exercise.data.Bar;
import com.fendy.exercise.data.Foo;
import com.fendy.exercise.data.FooBar;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

@Slf4j
@Configuration
public class DependsOnConfiguration {

    @Bean
    @DependsOn(value = {"bar"})
    public Foo foo() {
        log.info("Create new foo");
        return new Foo();
    }

    @Bean
    public Bar bar() {
        log.info("Create new bar");
        return new Bar();
    }

}
