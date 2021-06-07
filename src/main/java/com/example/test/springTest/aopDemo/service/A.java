package com.example.test.springTest.aopDemo.service;

public class A {

	private B b;

	public B getB() {
		return b;
	}

	public void setB(B b) {
		this.b = b;
        System.out.println("A call setB.");
	}
}