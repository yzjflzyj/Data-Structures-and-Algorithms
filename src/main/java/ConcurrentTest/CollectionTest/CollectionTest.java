package ConcurrentTest.CollectionTest;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

public class CollectionTest {
    public static void main(String[] args) {
        //ListConcurrentTest();
        //SetConcurrentTest();
        MapConcurrentTest();

    }

    //List集合的线程安全问题
    private static void ListConcurrentTest() {
        List<String> list = new ArrayList<>();  //多线程并发不安全
        //3.1 List<String> list = new Vector<>();
        //3.2 List<String> list = Collections.synchronizedList(new ArrayList<>());
        //3.3 List<String> list = new CopyOnWriteArrayList<>();

        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(list);
            }, String.valueOf(i)).start();
        }
    }

    //1.问题现象:java.util.ConcurrentModificationException  并发修改异常
    //2.原因分析:List线程不安全
    //3解决:
    // 3.1:使用Vector  :List<String> list = new Vector<>(); 效率低不建议
    //3.2:使用:使用Collections工具类,进行同步: List<String> list = Collections.synchronizedList(new ArrayList<>());
    //3.3写时复制 List<String> list = new CopyOnWriteArrayList<>(); 读写分离,在add时,复制一份长度大1的集合,add结束后,将原指针改为当前复制后的集合
    //4.优化


    //Set集合的线程安全问题
    //HashSet的底层是HashMap,只是值是一个固定的object类型的常量对象
    private static void SetConcurrentTest() {
        //Set<String> set = new HashSet<>();  //多线程并发不安全
        //3.1Set<String> set = Collections.synchronizedSet(new HashSet<>());
        Set<String> set = new CopyOnWriteArraySet<>();
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                set.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(set);
            }, String.valueOf(i)).start();
        }
    }
    //1.问题现象:java.util.ConcurrentModificationException  并发修改异常
    //2.原因分析:Set线程不安全
    //3解决:
    //3.1:使用:使用Collections工具类,进行同步: Set<String> set = Collections.synchronizedSet(new HashSet<>());
    //3.2写时复制 Set<String> set = new CopyOnWriteArraySet<>(); 读写分离,在add时,复制一份长度大1的集合,add结束后,将原指针改为当前复制后的集合
    //4.优化

    //Map集合的线程安全问题
    private static void MapConcurrentTest() {
        //Map<String,String> map = new HashMap<>();  //多线程并发不安全
        //Map<String,String> map =Collections.synchronizedMap(new HashMap<>());
        Map<String,String> map = new ConcurrentHashMap<>();
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                map.put(Thread.currentThread().getName(),UUID.randomUUID().toString().substring(0,8));
                System.out.println(map);
            }, String.valueOf(i)).start();
        }
    }
    //1.问题现象:java.util.ConcurrentModificationException  并发修改异常
    //2.原因分析:Set线程不安全
    //3解决:
    //3.1:使用:使用Collections工具类,进行同步: Map<String,String> map =Collections.synchronizedMap(new HashMap<>());
    //3.2ConcurrentHashMap   Map<String,String> map = new ConcurrentHashMap<>();
    //4.优化


}
