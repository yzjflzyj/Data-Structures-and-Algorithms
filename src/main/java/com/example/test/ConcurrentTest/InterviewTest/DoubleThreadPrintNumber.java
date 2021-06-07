package com.example.test.ConcurrentTest.InterviewTest;

import java.util.Scanner;
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
        System.out.println("请输入要执行的操作：");
        System.out.println("1、使用CountDownLatch实现");
        System.out.println("2、使用syncchronized实现");
        System.out.println("3、使用AtomicInteger实现");
        //创建Scanner对象，接受从控制台输入
        Scanner input = new Scanner(System.in);
        //接受String类型
        String str = input.next();
        switch (str) {
            case "1":
                doCountDownLatch();
                break;
            case "2":
                doSynchronized();
                break;
            case "3":
                doAtomicInteger();
                break;
            default:
                doAtomicInteger();
        }
    }

    /**
     * countdownlatch 实现
     */
    private static void doCountDownLatch() {
        Thread t1 = new Thread() {
            @Override
            public void run() {
                while (num.intValue() < 100) {
                    if (num.intValue() % 2 == 1) {

                        System.out.println("奇数线程:" + num.intValue());
                        num.incrementAndGet();
                    }
                    countDownLatch.countDown();
                }
            }
        };

        Thread t2 = new Thread() {
            @Override
            public void run() {
                while (num.intValue() <= 100) {
                    if (num.intValue() % 2 == 0) {
                        System.out.println("偶数线程:" + num.intValue());
                        num.incrementAndGet();
                    }
                    countDownLatch.countDown();
                }
            }
        };
        t1.start();
        t2.start();
        try {
            countDownLatch.await();

        } catch (Throwable e) {
            System.out.println(e);
        }
    }

    /**
     * synchronized 关键字实现
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
                    if (num.intValue() % 3 == 0) {
                        // reentrantLock.lock();
                        System.out.println(num.intValue());
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
                    if (num.intValue() % 3 == 1) {
                        System.out.println(num.intValue());
                        num.addAndGet(1);
                        //    reentrantLock.unlock();

                    } else {
                        //  reentrantLock.lock();

                    }
                }
            }
        }).start();
        // 第二个线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (; num.intValue() <= 100; ) {
                    if (num.intValue() % 3 == 2) {
                        System.out.println(num.intValue());
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
