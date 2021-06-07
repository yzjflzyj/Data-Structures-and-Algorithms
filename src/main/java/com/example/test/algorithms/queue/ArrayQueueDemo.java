package com.example.test.algorithms.queue;

import java.util.Scanner;

public class ArrayQueueDemo {
    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(3);
        char key = ' ';
        Scanner scanner = new Scanner(System.in);//
        boolean loop = true;
        while(loop) {
            System.out.println("s(show):展示数组");
            System.out.println("e(exit): 停止程序");
            System.out.println("a(add): 加入数据");
            System.out.println("g(get): 取出数据");
            System.out.println("h(head): 查看队列头");
            key = scanner.next().charAt(0);
            switch (key) {
                case 's':
                    queue.showQueue();
                    break;
                case 'a':
                    System.out.println("加入数据");
                    int value = scanner.nextInt();
                    queue.addQueue(value);
                    break;
                case 'g':
                    try {
                        int res = queue.getQueue();
                        System.out.printf("取出的数据是%d\n",res);
                    } catch (Exception e) {
                        // TODO: handle exception
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int res = queue.headQueue();
                        System.out.printf("队列头是%d\n", res);
                    } catch (Exception e) {
                        // TODO: handle exception
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }

        System.out.println("³ÌÐòÍË³ö~~");
    }

}

class ArrayQueue {
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;

    //构造函数
    public ArrayQueue(int arrSize) {
        front = -1;
        rear = -1;
        maxSize = arrSize;
        arr = new int[maxSize];
    }

    //判空
    public boolean isEmpty(){
        return front==rear;
    }

    //判满
    public boolean isFull(){
        return rear==maxSize;
    }

    //加入数据
    public void addQueue(int n){
        if (isFull()){
            System.out.println("已经满了，无法增加数据");
            return;
        }
       arr[++rear]=n;
    }

    //取出数据
    public int getQueue(){
        if (isEmpty()){
            throw new RuntimeException("空队列,无法取出");
        }
        return arr[++front];
    }

    //展示数组
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列为空~");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n", i, arr[i]);
        }
    }

    //展示队列头
    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空~");
        }
        return arr[front + 1];
    }
}

