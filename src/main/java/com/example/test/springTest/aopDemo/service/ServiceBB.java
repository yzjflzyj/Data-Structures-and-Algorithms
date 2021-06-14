package com.example.test.springTest.aopDemo.service;

public class ServiceBB{
    private ServiceAA serviceAA;
    //用set方法,可以支持循环依赖
    public void setServiceAA(ServiceAA serviceAA){
        this.serviceAA = serviceAA;
        System.out.println("B里面设置了A");
    }

    public ServiceAA getServiceAA(){
        return serviceAA;
    }
}