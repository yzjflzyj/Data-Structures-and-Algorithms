package com.example.test.ConcurrentTest.volatileTest;

public class SingletonDemo {
    private static volatile SingletonDemo instance;
    //volatile是为了禁止指令重排,new SingletonDemo();分为三步:1.分配空间2.对象初始化 3.指针指向这块空间,
    // 指令重排导致2和3可能调换位置,导致判断为null时,判断不为null直接使用对象时,但是对象并没有初始化完,存在线程安全问题
    public SingletonDemo() {
        System.out.println("进入构造方法");
    }

    public static SingletonDemo getInstance() {
        if (instance==null){   //为了效率,如果线程不为null,多线程进入同步去判断,浪费
            synchronized (SingletonDemo.class){
                if (instance==null){   //为了同步,多线程安全
                    instance=new SingletonDemo();
                }
            }
        }
        return instance;
    }
}
