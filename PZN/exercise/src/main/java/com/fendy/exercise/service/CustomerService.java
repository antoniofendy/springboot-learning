package com.fendy.exercise.service;

        import com.fendy.exercise.repository.CustomerRepository;
        import lombok.Getter;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Component;

@Component
public class CustomerService {

    @Getter
    @Autowired
    private CustomerRepository customerRepository;

}
