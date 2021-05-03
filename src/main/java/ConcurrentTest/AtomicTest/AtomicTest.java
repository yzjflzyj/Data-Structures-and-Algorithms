package ConcurrentTest.AtomicTest;

import lombok.Data;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

public class AtomicTest {
    //CAS,期望值与主内存的值比较,相同即更新,不相同即循环重试,自旋.
    //不相同时,其他线程已经修改其值,但是由于变量被volatile修饰,具有可见性,能更新期望值,下一次继续比较; atomicInteger.compareAndSet(1, 1);
    //CAS优点:提高并发量,缺点:有可能增加cpu负担,尤其是当一个线程经常被其他线程插队,导致多次自旋,浪费性能;还存在ABA问题, 即变量的值,由A被别的线程改为B后又改回A,而原线程并不知道,如果业务环境不在乎中间状态就没有关系,如果在乎中间状态,就会出现问题
    //ABA问题的解决:带版本号的原子引用类

    public static void main(String[] args) {
        //CASTest(new User());
        //atomicReferenceTest();
        atomicStampedReferenceTest();
    }

    //带版本号的原子引用类,解决ABA问题
    private static void atomicStampedReferenceTest() {
        AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference(0, 0);
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t当前版本号是" + atomicStampedReference.getStamp());
            atomicStampedReference.compareAndSet(0, 100, atomicStampedReference.getStamp(), atomicStampedReference.getStamp()+1);
            atomicStampedReference.compareAndSet(100, 101, atomicStampedReference.getStamp(), atomicStampedReference.getStamp()+1);
            atomicStampedReference.compareAndSet(101, 100, atomicStampedReference.getStamp(), atomicStampedReference.getStamp()+1);
        }, "t1").start();
        new Thread(() -> {
            int stamp = atomicStampedReference.getStamp();
            System.out.println(Thread.currentThread().getName() + "\t当前版本号是" + atomicStampedReference.getStamp() + "\t值是" + atomicStampedReference.getReference());
            try {TimeUnit.SECONDS.sleep(3); } catch(InterruptedException e) {e.printStackTrace(); }
            System.out.println(Thread.currentThread().getName() + "\t当前版本号是" + atomicStampedReference.getStamp() + "\t值是" + atomicStampedReference.getReference());
            boolean result1 = atomicStampedReference.compareAndSet(100, 102, stamp, atomicStampedReference.getStamp() + 1);
            System.out.println(Thread.currentThread().getName() + "\t当前版本号是" + atomicStampedReference.getStamp() + "\t值是" + atomicStampedReference.getReference()+"\t修改结果是"+result1);
            boolean result2 = atomicStampedReference.compareAndSet(100, 103, atomicStampedReference.getStamp(), atomicStampedReference.getStamp() + 1);
            System.out.println(Thread.currentThread().getName() + "\t当前版本号是" + atomicStampedReference.getStamp() + "\t值是" + atomicStampedReference.getReference()+"\t修改结果是"+result2);
        }, "t2").start();
    }

    //
    private static void atomicReferenceTest() {
        User user1 = new User("关羽", 25);
        User user2 = new User("刘备", 27);
        AtomicReference<User> userAtomicInteger = new AtomicReference<>();
        userAtomicInteger.set(user1);
        System.out.println(userAtomicInteger.get().toString());
        userAtomicInteger.compareAndSet(user1, user2);
        System.out.println(userAtomicInteger.get().toString());
        userAtomicInteger.compareAndSet(user1, user2);
        System.out.println(userAtomicInteger.get().toString());
    }

    //CAS
    private static void CASTest(User user) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    user.CASTest();
                }
            }, String.valueOf(i)).start();
        }
        while (Thread.activeCount() > 2) {  //2是有main线程和GC线程
            Thread.yield();
        }
        System.out.println(user.atomicInteger);
    }

    @Data
    static class User {
        private int age;
        private String name;

        public User() {
        }

        public User(String name, int age) {
            this.age = age;
            this.name = name;
        }

        AtomicInteger atomicInteger = new AtomicInteger(); //默认是0

        //CAS测试
        public void CASTest() {
            atomicInteger.compareAndSet(0, 10);
        }
    }
}
