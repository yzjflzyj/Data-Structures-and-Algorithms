package com.example.test.ConcurrentTest.CallableDemo;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableDemo {

    public static void main(String[] args) {
        /**
         * FutureTask类实现了RunnableFuture接口,RunnableFuture接口是Runnable接口的子接口
         * 体现了适配器默认的设计模式思想
         */
        FutureTask<Integer> futureTask = new FutureTask<>(new MyThread());
        Thread t = new Thread(futureTask, "threadName");
        t.start();
        try {
            Integer result = futureTask.get();  //会阻塞直到取到结果,也可以带超时时间,一般放后面
            while (!futureTask.isDone()){  //也可以采用这种,没有算完就阻塞等待

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

}


class MyThread implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println("实现Callable call方法");
        return 1024;
    }
}