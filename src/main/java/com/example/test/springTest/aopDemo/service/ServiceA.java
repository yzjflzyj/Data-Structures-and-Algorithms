package com.example.test.springTest.aopDemo.service;

import org.springframework.stereotype.Component;

@Component
public class ServiceA{
    private ServiceB serviceB;
    
    public ServiceA(ServiceB serviceB){
        this.serviceB = serviceB;
    }
}