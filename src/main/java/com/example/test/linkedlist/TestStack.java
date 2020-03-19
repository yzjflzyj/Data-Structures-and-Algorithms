package com.example.test.linkedlist;

import java.util.Stack;

//��ʾջStack�Ļ���ʹ��
public class TestStack {

	public static void main(String[] args) {
		Stack<String> stack = new Stack();
		// 压栈
		stack.add("jack");
		stack.add("tom");
		stack.add("smith");

		// 出栈
		// smith, tom , jack
		while (stack.size() > 0) {
			System.out.println(stack.pop());
		}
	}

}
