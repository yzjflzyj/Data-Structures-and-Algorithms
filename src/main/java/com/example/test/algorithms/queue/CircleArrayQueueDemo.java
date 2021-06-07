package com.example.test.algorithms.queue;

import java.util.Scanner;

public class CircleArrayQueueDemo {

    public static void main(String[] args) {

        CircleArray queue = new CircleArray(4);
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;

        while (loop) {
            System.out.println("s(show):展示队列数据");
            System.out.println("e(exit): 结束循环");
            System.out.println("a(add): 增添数据");
            System.out.println("g(get): 取出数据");
            System.out.println("h(head): 展示队列头");
            key = scanner.next().charAt(0);
            switch (key) {
                case 's':
                    queue.showQueue();
                    break;
                case 'a':
                    System.out.println("请输入需要添加的元素");
                    int value = scanner.nextInt();
                    queue.addQueue(value);
                    break;
                case 'g':
                    try {
                        int res = queue.getQueue();
                        System.out.printf("取出的元素是:%d\n", res);
                    } catch (Exception e) {
                        // TODO: handle exception
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int res = queue.headQueue();
                        System.out.printf("队列的数据头是:%d\n", res);
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
        System.out.println("程序结束");
    }

}


class CircleArray {
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;

    public CircleArray(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
    }

    //判满
    public boolean isFull() {
        return (rear+1) % maxSize == front;
    }

    //判空
    public boolean isEmpty() {
        return rear == front;
    }

    //添加元素
    public void addQueue(int n) {

        if (isFull()) {
            System.out.println("队列已满");
            return;
        }

        arr[rear] = n;

        rear = (rear + 1) % maxSize;
    }

    //取出数据
    public int getQueue() {

        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }

        int value = arr[front];
        front = (front + 1) % maxSize;
        return value;

    }

    //展示队列
    public void showQueue() {

        if (isEmpty()) {
            System.out.println("队列为空");
            return;
        }

        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
        }
    }

    //获取队列长度
    public int size() {
        return (rear + maxSize - front) % maxSize;
    }

    //展示队列头
    public int headQueue() {

        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        return arr[front];
    }
}