package jvmTest;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

public class ReferenceDemo {

    public static void main(String[] args) {
        //strongReference();
        //softReference();
        //weakReference();
        //phantomReference();
        weaMapDemo();
    }


    //weakHashMap的使用
    private static void weaMapDemo() {
        Map<Integer, String> map = new WeakHashMap<>();
        Integer key = new Integer(1);
        map.put(key, "gc前");
        System.out.println(map.get(key));
        key=null;
        System.gc();
        System.out.println(map.get(key));
    }

    //虚引用，任何时候都可能被回收，主要是跟踪对象被回收的状态，说明对象进入finalization阶段。PhantomReference.get()方法一定是null。一定要配合引用队列使用
    private static void phantomReference() {
        Object o1 = new Object();
        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
        PhantomReference phantomReference = new PhantomReference(o1,referenceQueue);
        System.out.println(o1);
        System.out.println(phantomReference.get());  //永远为null，该方法形同虚设
        //手动gc
        o1=null;
        System.gc();
        System.out.println(o1);
        System.out.println(phantomReference.get());//为null
        System.out.println(referenceQueue.poll());//不为null
    }

    //弱引用，gc一定会回收
    private static void weakReference() {
        Object o1 = new Object();
        WeakReference weakReference = new WeakReference(o1);//构造时也可以再传一个引用队列，referenceQueue.poll()在回收之前能获得对象
        System.out.println(o1);
        System.out.println(weakReference.get());
        //手动gc
        o1=null;
        System.gc();
        System.out.println(o1);
        System.out.println(weakReference.get());//为null
    }

    //软引用，gc也不一定会回收，只有在内存不够的时候会回收
    private static void softReference() {
        Object o1 = new Object();
        SoftReference softReference = new SoftReference(o1);//构造时也可以再传一个引用队列，referenceQueue.poll()在回收之前能获得对象
        System.out.println(o1);
        System.out.println(softReference.get());
        //手动gc
        o1=null;
        System.gc();
        System.out.println(o1);
        System.out.println(softReference.get());//不为null
        //内存溢出，指定内存 -Xms20m -Xmx20m -XX:+PrintGCDetails
        try {
            byte[] bytes = new byte[1024 * 1024 * 30];
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println(o1);
            System.out.println(softReference.get());//为null
        }

    }

    //强引用,通过中间变量的赋值，其实质还是指向的对象，不会在赋值之后中间变量变化而变化
    private static void strongReference() {
        Object o1 = new Object(); //构造时也可以再传一个引用队列，referenceQueue.poll()在回收之前能获得对象
        Object o2=o1;
        System.out.println(o1);
        System.out.println(o2);
        o1=null;
        System.out.println(o1);
        System.out.println(o2);
    }
}
