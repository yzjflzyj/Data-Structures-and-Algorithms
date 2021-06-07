package com.example.test.springTest.aopDemo.service;

public class ClientSet{
    public static void main(String[] args){
        //创建serviceAA
        ServiceAA a = new ServiceAA();
        //创建serviceBB
        ServiceBB b = new ServiceBB();
        //将serviceA入到serviceB中
        b.setServiceAA(a);
        //将serviceB法入到serviceA中
        a.setServiceBB(b);
    }
}