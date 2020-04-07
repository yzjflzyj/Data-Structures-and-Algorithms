package com.example.test.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class ShellSort {
    public static void main(String[] args) {
        //创建0-100000之间的随机数组
        int[] arr = new int[100000];
        for (int i = 0; i < 100000; i++) {
            arr[i] = (int) (Math.random() * 8000000); // 生成一个[0, 8000000) 数
        }

        System.out.println("排序前的数组为" + Arrays.toString(arr));
        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("排序前的时间是=" + date1Str);

        shellSort1(arr);

        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("排序前的时间是=" + date2Str);
        System.out.println("排序后的数组为" + Arrays.toString(arr));
    }

    /**
     * 分组插入排序
     * @param arr
     */
    public static void shellSort1(int[] arr) {
        int insertVal;
        int index;
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            //分为gap个组,每个组的步长也为gap
            //使用插入排序
            for (int i = gap; i < arr.length; i++) {
                insertVal = arr[i];
                index = i - gap;
                while (index >= 0 && insertVal < arr[index]) {
                    arr[index + gap] = arr[index];
                    index -= gap;
                }
                //如果不需要往后插入,那么不再重复赋值
                if (index != i - gap) {
                    arr[index + gap] = insertVal;
                }

            }
        }
    }

}
