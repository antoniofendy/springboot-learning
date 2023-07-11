package com.fendy.exercise;

import com.fendy.exercise.repository.CategoryRepository;
import com.fendy.exercise.repository.CustomerRepository;
import com.fendy.exercise.repository.ProductRepository;
import com.fendy.exercise.service.CategoryService;
import com.fendy.exercise.service.CustomerService;
import com.fendy.exercise.service.ProductService;
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
        ProductService productService = applicationContext.getBean(ProductService.class);
        ProductService productService2 = applicationContext.getBean("productService", ProductService.class);
        Assertions.assertSame(productService, productService2);
    }

    @Test
    void testComponentConstructorDependencyInjection() {
        ProductService productService = applicationContext.getBean(ProductService.class);
        Assertions.assertNotNull(productService.getProductRepository());

        ProductRepository productRepository = applicationContext.getBean(ProductRepository.class);
        Assertions.assertSame(productRepository, productService.getProductRepository());
    }

    @Test
    void testComponentSetterDependencyInjection() {
        CategoryService categoryService = applicationContext.getBean(CategoryService.class);
        Assertions.assertNotNull(categoryService.getCategoryRepository());

        CategoryRepository categoryRepository = applicationContext.getBean(CategoryRepository.class);
        Assertions.assertSame(categoryService.getCategoryRepository(), categoryRepository);
    }

    // This dependency injection method is not recommended to be used by now
    @Test
    void testComponentFieldDependencyInjection() {
        CustomerService customerService = applicationContext.getBean(CustomerService.class);

        CustomerRepository normalCustomerRepository = applicationContext.getBean("normalCustomerRepository", CustomerRepository.class);
        CustomerRepository premiumCustomerRepository = applicationContext.getBean("premiumCustomerRepository", CustomerRepository.class);

        Assertions.assertSame(customerService.getNormalCustomerRepository(), normalCustomerRepository);
        Assertions.assertNotSame(normalCustomerRepository, premiumCustomerRepository);
    }

}
