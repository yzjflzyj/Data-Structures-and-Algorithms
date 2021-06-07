package com.example.test.springTest.aopDemo.service;

import com.example.test.springTest.aopDemo.service.ServiceA;
import com.example.test.springTest.aopDemo.service.ServiceB;

public class ClientConstructor{
    public static void main(String[] args){
        //构造方法注入会有循环依赖的问题
        //new ServiceA(new ServiceB(new ServiceA()));//这会抛出编译异常
    }
}