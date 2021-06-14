package com.example.test.springTest.aopDemo.service;

public class ServiceAA{
    private ServiceBB serviceBB;
    //用set方法,可以支持循环依赖
    public void setServiceBB(ServiceBB serviceBB){
        this.serviceBB = serviceBB;
        System.out.println("A里面设置了B");
    }

    public ServiceBB getServiceBB(){
        return serviceBB;
    }
}