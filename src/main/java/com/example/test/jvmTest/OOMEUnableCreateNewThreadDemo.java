package com.example.test.jvmTest;

import java.util.concurrent.TimeUnit;

public class OOMEUnableCreateNewThreadDemo {
    /**
     * 不能够创建更多的新的线程了，也就是说创建线程的上限达到
     * @param args
     */
    public static void main(String[] args) {
        for (int i = 0; ; i++) {
            System.out.println("************** i = " + i);
            new Thread(() -> {
                try {
                    TimeUnit.SECONDS.sleep(Integer.MAX_VALUE);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, String.valueOf(i)).start();
        }
    }
}