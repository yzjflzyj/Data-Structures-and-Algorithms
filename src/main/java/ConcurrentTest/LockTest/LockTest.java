package ConcurrentTest.LockTest;

import java.util.concurrent.locks.ReentrantLock;

public class LockTest {
    public static void main(String[] args) {
        Phone phone = new Phone();
        //synchronizedTest(phone);
        //reentrantLockTest(phone);

    }


    //reentrantLock可重入锁的demo
    private static void reentrantLockTest(Phone phone) {
        phone.run();
    }

    //synchronized可重入锁的demo
    private static void synchronizedTest(Phone phone) {
        new Thread(() -> {
            try {
                phone.sendMes();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "t1").start();
        new Thread(() -> {
            try {
                phone.sendMes();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "t2").start();
    }


}

class Phone implements Runnable{
    public synchronized void sendMes() throws Exception {
        System.out.println(Thread.currentThread().getName() + "\tinvoke message");
        sendEmail();
    }

    public synchronized void sendEmail() throws Exception {
        System.out.println(Thread.currentThread().getName() + "\tinvoke email");
    }


    ReentrantLock lock=new ReentrantLock();
    @Override
    public void run() {
        set();
    }

    public void get(){

        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t进入get方法");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void set(){

        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t进入set方法");
            get();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}



