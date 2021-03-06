package com.example.test.ConcurrentTest.ThreadPoolDemo;

import java.util.concurrent.*;

public class ThreadPoolDemo {
    public static void main(String[] args) {
        //Executors创建线程池,底层都是new ThreadPoolExecutor
        Executors.newCachedThreadPool();    //最大线程数是Integer的最大值,阻塞队列SynchronousQueue 不存储任务, 任务已提交就执行
        Executors.newFixedThreadPool(5);
        Executors.newSingleThreadExecutor();         //阻塞队列是LinkedBlockingQueue,阻塞队列的最大长度是Integer的最大值

        /*
           四种拒绝策略
        *  第一种拒绝策略是 AbortPolicy，这种拒绝策略在拒绝任务时，会直接抛出一个类型为 RejectedExecutionException 的 RuntimeException，让你感知到任务被拒绝了，于是你便可以根据业务逻辑选择重试或者放弃提交等策略。
           第二种拒绝策略是 DiscardPolicy，这种拒绝策略正如它的名字所描述的一样，当新任务被提交后直接被丢弃掉，也不会给你任何的通知，相对而言存在一定的风险，因为我们提交的时候根本不知道这个任务会被丢弃，可能造成数据丢失。
           第三种拒绝策略是 DiscardOldestPolicy，如果线程池没被关闭且没有能力执行，则会丢弃任务队列中的头结点，通常是存活时间最长的任务，这种策略与第二种不同之处在于它丢弃的不是最新提交的，而是队列中存活时间最长的，这样就可以腾出空间给新提交的任务，但同理它也存在一定的数据丢失风险。
           第四种拒绝策略是 CallerRunsPolicy，相对而言它就比较完善了，当有新任务提交后，如果线程池没被关闭且没有能力执行，则把这个任务交于提交任务的线程执行，也就是谁提交任务，谁就负责执行任务。这样做主要有两点好处。
             第一点新提交的任务不会被丢弃，这样也就不会造成业务损失。
             第二点好处是，由于谁提交任务谁就要负责执行任务，这样提交任务的线程就得负责执行任务，而执行任务又是比较耗时的，在这段期间，提交任务的线程被占用，也就不会再提交新的任务，减缓了任务提交的速度，相当于是一个负反馈。
                  在此期间，线程池中的线程也可以充分利用这段时间来执行掉一部分任务，腾出一定的空间，相当于是给了线程池一定的缓冲期。
        * */

        /*
        * 线程池可以提交Runnable(包含FutureTask)和Callable接口(返回值是Future接口)
        * 线程只能提交Runnable接口(包含FutureTask)
        * */
        //线程池提交Runnable接口
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Future<Integer> future1 = executorService.submit(() -> {
            return 512;
        });
        try {
            Integer integer1 = future1.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        /**
         * FutureTask类实现了RunnableFuture接口,RunnableFuture接口是Runnable接口的子接口
         * 体现了适配器默认的设计模式思想
         * FutureTask类实现了Future接口
         */
        //线程池提交FutureTask
        FutureTask<Integer> futureTask=new FutureTask(new MyThread());
        executorService.submit(futureTask);
        try {
            Integer integer2 = futureTask.get();//Future的get方法还可以带过期时间,在时间内阻塞;还存在cancel方法取消正在执行的任务,还有isDone的判断完成的方法
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        //线程池提交Callable接口
        Future<Integer> future3 = executorService.submit(new MyThread());
        try {
            Integer integer3 = future3.get();
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
