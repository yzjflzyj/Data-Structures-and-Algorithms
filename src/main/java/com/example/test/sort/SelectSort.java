package com.example.test.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class SelectSort {
    public static void main(String[] args) {
        //创建0-100000之间的随机数组
        int[] arr = new int[100000];
        for (int i = 0; i < 100000; i++) {
            arr[i] = (int) (Math.random() * 8000000); // 生成一个[0, 8000000) 数
        }
        //int[] arr = {1, 2, 4, 6, 3, 5, 8, 9, 7, 0};

        System.out.println("排序前的数组为" + Arrays.toString(arr));
        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("排序前的时间是=" + date1Str);

        selectSort(arr);

        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("排序前的时间是=" + date2Str);
        System.out.println("排序后的数组为" + Arrays.toString(arr));
    }

    public static void selectSort(int[] arr) {
        int minVal,index;
        for (int i = 0; i < arr.length; i++) {
            minVal = arr[i];
            index = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < minVal) {
                    minVal = arr[j];
                    index = j;
                }
            }
            arr[index] =arr[i];
            arr[i]=minVal;
        }

    }
}
