package com.example.test.ConcurrentTest.LockTest;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public class SpinLockDemo {
    //手写自旋,自选的优点是,减少线程的阻塞,避免线程切换带来的开销,缺点是如果浪费cpu资源,尤其是长久无法拿到锁的时候
    AtomicReference<Thread> atomicReference=new AtomicReference<>();

    public static void main(String[] args) {
        SpinLockDemo spinLockDemo = new SpinLockDemo();
        new Thread(()->{
            spinLockDemo.myLock();
            try {TimeUnit.SECONDS.sleep(5); } catch(InterruptedException e) {e.printStackTrace(); }
            spinLockDemo.myUnlock();
        },"t1").start();
        try {TimeUnit.SECONDS.sleep(1); } catch(InterruptedException e) {e.printStackTrace(); }
        new Thread(()->{
            spinLockDemo.myLock();
            try {TimeUnit.SECONDS.sleep(2); } catch(InterruptedException e) {e.printStackTrace(); }
            spinLockDemo.myUnlock();
        },"t2").start();
    }

    public void myLock(){
        Thread thread=Thread.currentThread();
        //一开始进来的原子引用类,不用在此自旋
        while(!atomicReference.compareAndSet(null,thread)){

        }
        System.out.println(thread.getName()+"\t获得了锁");
    }

    public void myUnlock(){
        Thread thread=Thread.currentThread();
        atomicReference.compareAndSet(thread,null);
        System.out.println(thread.getName()+"\t释放了锁");
    }
}
