package com.example.test.springTest.aopDemo.service;

import org.springframework.stereotype.Component;

//@Component 构造方法注入,不支持循环依赖
public class ServiceB{
    private ServiceA serviceA;
    
    public ServiceB(ServiceA serviceA){
        this.serviceA = serviceA;
    }
}