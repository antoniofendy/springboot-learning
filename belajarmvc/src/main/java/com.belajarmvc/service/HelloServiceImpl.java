package com.belajarmvc.service;

import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService {
    @Override
    public String hello(String name) {
        if(name != null) {
            return "Hello " + name;
        } else {
            return "Hello Guest";
        }
    }
}
