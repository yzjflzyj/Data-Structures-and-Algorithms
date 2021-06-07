package com.example.test.springTest.aopDemo.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ClientSpringContainer {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		/*beans.xml中,默认是singleton,当设置为scope="prototype"时,就会报错,即原型(Prototype)的场景是不支持循环依赖的*/
		ServiceAA a = context.getBean("a", ServiceAA.class);
		ServiceBB b = context.getBean("b", ServiceBB.class);
	}
}