package com.fendy.exercise;

import com.fendy.exercise.data.Foo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class LazyBeanTest {
    
    private ApplicationContext applicationContext;
    
    @BeforeEach
    void setUp() {
        applicationContext = new AnnotationConfigApplicationContext(LazyBeanConfiguration.class);
    }
    
    @Test
    void testLazyBean() {
        // Foo bean object not created, because it annotated as @Lazy
        // Foo bean object will only create if we get it manually in our code
    }
    
    @Test
    void testLazyBeanAccess() {
        // Foo bean object created when we get it at below code
        Foo foo = applicationContext.getBean(Foo.class);
    }
    
}
