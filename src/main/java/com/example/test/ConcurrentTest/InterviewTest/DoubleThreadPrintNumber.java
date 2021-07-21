package com.example.test.ConcurrentTest.InterviewTest;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class DoubleThreadPrintNumber {
    public static int i = 1;
    public static Object lock = new Object();
    private static AtomicInteger num = new AtomicInteger(1);
    private static CountDownLatch countDownLatch = new CountDownLatch(2);

    public static void main(String[] args) throws InterruptedException {

        //其他思路volatile的标志位,两个线程相互翻转状态
        System.out.println("请输入要执行的操作：");
        System.out.println("1、使用blockQueue实现");
        System.out.println("2、使用synchronized实现");
        System.out.println("3、使用AtomicInteger实现");
        //创建Scanner对象，接受从控制台输入
        Scanner input = new Scanner(System.in);
        //接受String类型
        String str = input.next();
        switch (str) {
            case "1":
                doBlockQueue();
                break;
            case "2":
                doSynchronized();
                break;
            case "3":
                doAtomicInteger();
                break;
            default:
                break;
        }
    }

    /**
     * 利用阻塞队列的阻塞等待来实现交替
     */
    private static void doBlockQueue() {
        final BlockingQueue<Integer> blockingQueue1 = new ArrayBlockingQueue<Integer>(1);
        final BlockingQueue<Integer> blockingQueue2 = new ArrayBlockingQueue<Integer>(1);
        new Thread(new Runnable() {
            public void run() {
                for (int i = 1; i <= 100; i = i + 2) {
                    try {
                        blockingQueue1.put(i);
                        System.out.println("队列2:"+blockingQueue2.take());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        new Thread(new Runnable() {
            public void run() {
                for (int i = 2; i <= 100; i = i + 2) {
                    try {
                        System.out.println("队列1:"+blockingQueue1.take());
                        blockingQueue2.put(i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }


    /**
     * synchronized的notify和wait
     * ReentrantLock,和condition的signal和await
     */
    private static void doSynchronized() {
        int TOTAL = 100;
        Thread thread1 = new Thread(() -> {
            while (i <= TOTAL) {
                synchronized (lock) {
                    if (i % 2 == 1) {
                        System.out.println("i=" + i++);
                        lock.notify();
                        System.out.println("奇数打印完毕，释放锁");
                    } else {
                        try {
                            System.out.println("奇数锁等待");
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
        Thread thread2 = new Thread(() -> {
            while (i <= TOTAL) {
                synchronized (lock) {
                    if (i % 2 == 0) {
                        System.out.println("i=" + i++);
                        lock.notify();
                        System.out.println("偶数打印完毕，释放锁");

                    } else {
                        try {
                            System.out.println("偶数锁等待");
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
        thread1.start();
        thread2.start();
    }

    /**
     * AtomicInteger实现
     */
    public static void doAtomicInteger() {
        ReentrantLock reentrantLock = new ReentrantLock();
        Condition condition = reentrantLock.newCondition();
        new Thread(new Runnable() {
            int i = 1;

            // 第一个线程
            @Override
            public void run() {
                for (; num.intValue() <= 100; ) {
                    if (num.intValue() % 2 == 1) {
                        // reentrantLock.lock();
                        System.out.println("线程1:" + num.intValue());
                        num.addAndGet(1);
                        //reentrantLock.unlock();
                    } else {

                    }
                }
            }
        }).start();
        // 第二个线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (; num.intValue() <= 100; ) {
                    if (num.intValue() % 2 == 0) {
                        System.out.println("线程2:" + num.intValue());
                        num.addAndGet(1);
                        //    reentrantLock.unlock();

                    } else {
                        //  reentrantLock.lock();

                    }
                }
            }
        }).start();
    }
}
