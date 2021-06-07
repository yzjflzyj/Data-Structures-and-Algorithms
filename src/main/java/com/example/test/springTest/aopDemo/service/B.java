package com.example.test.springTest.aopDemo.service;

public class B {

	private A a;

	public A getA() {
		return a;
	}

	public void setA(A a) {
		this.a = a;
        System.out.println("B call setA.");
	}	
}