package com.example.test.stack;

import java.util.Scanner;

public class ArrayStackDemo {

    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(4);
        String key = "";
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);

        while(loop) {
            System.out.println("show:展示栈");
            System.out.println("exit:退出");
            System.out.println("push:压栈");
            System.out.println("pop:弹栈");
            System.out.println("请输入指令");
            key = scanner.next();
            switch (key) {
                case "show":
                    stack.list();
                    break;
                case "push":
                    System.out.println("请输入入栈数据");
                    int value = scanner.nextInt();
                    stack.push(value);
                    break;
                case "pop":
                    try {
                        int res = stack.pop();
                        System.out.printf("出栈数据是:%d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "exit":
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }

        System.out.println("结束程序");
    }

}

class ArrayStack {
    private int maxSize;
    private int[] stack;
    private int top = -1;

    //构造方法
    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    //判满
    public boolean isFull() {
        return top == maxSize - 1;
    }
    //判空
    public boolean isEmpty() {
        return top == -1;
    }
    //入栈
    public void push(int value) {
        if(isFull()) {
            System.out.println("栈已满");
            return;
        }
        top++;
        stack[top] = value;
    }
    //弹栈
    public int pop() {
        //判空
        if(isEmpty()) {
            throw new RuntimeException("栈为空");
        }
        int value = stack[top];
        top--;
        return value;
    }
    //展示栈元素
    public void list() {
        if(isEmpty()) {
            System.out.println("栈为空");
            return;
        }

        for(int i = top; i >= 0 ; i--) {
            System.out.printf("stack[%d]=%d\n", i, stack[i]);
        }
    }

}

