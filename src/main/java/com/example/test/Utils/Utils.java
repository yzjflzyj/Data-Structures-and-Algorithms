package com.example.test.Utils;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class Utils {


    /**
     * 打印当前数组和当前时间
     * @param a
     */
    public static void timePrint(int[] a){
        System.out.println("当前数组为" + Arrays.toString(a));
        Date data = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr = simpleDateFormat.format(data);
        System.out.println("当前时间是=" + dateStr);
    }

    public static void timePrint(String str){
        Date data = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr = simpleDateFormat.format(data);
        System.out.println(str+"当前时间是=" + dateStr);
    }


    /**
     * 随机自动生成a个在[0, b)范围内的数组
     * @param a
     * @param b
     * @return
     */
    public static int[] autoCreateArray(int a,int b){
        int[] arr = new int[a];
        for (int i = 0; i < a; i++) {
            arr[i] = (int) (Math.random() * b); // 生成一个[0, b) 数
        }
        return arr;
    }


    /**
     * 交换数组a,索引i和j对应元素的位置
     * @param a
     * @param i
     * @param j
     * @return
     */
    public static void exch(int[] a, int i, int j) {
        int temp;
        temp = a[j];
        a[j] = a[i];
        a[i] = temp;
    }

    // exchange a[i] and a[j]
    public static void exch(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }


    /**
     * 默认前小后大的排序方式
     * @param a
     * @param lo
     * @param hi
     * @return
     */
    public static boolean isSorted(int[] a, int lo, int hi) {
        for (int i = lo + 1; i < hi; i++)
            if (less(a[i], a[i-1])) return false;
        return true;
    }

    public static boolean isSorted(int[] a) {
        return isSorted(a, 0, a.length);
    }



    /**
     * 判断是否小于
     * @param v
     * @param w
     * @return
     */
    // is v < w ?
    public static boolean less(int v, int w) {
        return v< w;
    }

}
