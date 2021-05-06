package ConcurrentTest.SemaphoreTest;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreDemo {
    //Semaphore信号量,作用1:控制多个共享资源的互斥使用,2:用于并发线程的控制
    public static void main(String[] args) {
        Semaphore semaphore=new Semaphore(5);
        for (int i = 0; i < 10; i++) {
            final int temp=i;
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    System.out.println(temp+"\t获得资源");
                    try { TimeUnit.SECONDS.sleep(3); } catch(InterruptedException e) {e.printStackTrace(); }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    semaphore.release();
                    System.out.println(temp+"\t释放资源");
                }
            }, String.valueOf(i)).start();
        }
    }
}
