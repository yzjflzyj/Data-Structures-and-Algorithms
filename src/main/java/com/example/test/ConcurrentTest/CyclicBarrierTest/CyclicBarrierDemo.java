package com.example.test.ConcurrentTest.CyclicBarrierTest;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {
    public static void main(String[] args) {
        CyclicBarrierTest();
    }

    /**
     * 与CountDownLatch的区别在于CyclicBarrier是可以循环的,即例如,在while循环里多个线程进行任务,每个线程到达某个点后
       等待各个线程到齐后,进行总任务后,继续进行各个分线程的循环任务
     */
    private static void CyclicBarrierTest() {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(10,()->{System.out.println("班长锁门走了");});
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "同学\t离开自习室了");
                try {
                    cyclicBarrier.await();//数目到parties,才能继续()->{System.out.println("班长锁门走了"),然后再执行await方法之后的
                System.out.println("执行了");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }, String.valueOf(i)).start();
        }
    }

}
