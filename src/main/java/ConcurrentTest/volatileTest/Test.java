package ConcurrentTest.volatileTest;

import lombok.Data;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Test {

    public static void main(String[] args) {
        //两个线程交替打印0-100
        /*ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(i+1);
        }
        Thread t1=new Thread(()->

                );
        Thread t2=new Thread();


        int [] arr=new int[]{1,2,3,4,10,6,7,8,9,5};
        int tem=0;
        for (int i = 0; i < arr.length; i++) {
            tem=arr[i]>tem?arr[i]:tem;
        }
        System.out.println(tem);*/


        //volatile的可见性验证
        MyData myData = new MyData();

        //volatileVisibility(myData);
        volatileAtom(myData);

    }

    //验证volatile原子性
    private static void volatileAtom(MyData myData) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    myData.addNum();
                    //myData.addAtomic();
                    myData.atomicInteger.getAndIncrement();
                    //myData.atomicInteger.getAndAdd(1);
                }
            }, String.valueOf(i)).start();
        }
        while (Thread.activeCount() > 2) {  //2是有main线程和GC线程
            Thread.yield();
        }
        System.out.println(myData.num);
        System.out.println(myData.atomicInteger);
    }

    /*验证volatile的可见性
     * @Author codeHu
     * @Description
     * @Date 20:43 2021/4/30
     * @Param [myData]
     * @return void
     **/
    private static void volatileVisibility(MyData myData) {
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + myData.num);
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            myData.setNum(10);
            System.out.println(Thread.currentThread().getName() + myData.num);
        }, "threadName").start();


        while (myData.num == 0) {

        }
        System.out.println(Thread.currentThread().getName() + "mission is over");
    }
}

@Data
class MyData {
    public volatile int num = 0;
    AtomicInteger atomicInteger = new AtomicInteger(); //默认是0

    public void addNum() {
        num++;
    }

    public void addAtomic() {
        //atomicInteger.getAndAdd(1);
        atomicInteger.getAndIncrement();
    }
}
