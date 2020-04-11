package com.example.test.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class RadixSort {
    public static void main(String[] args) {
        //创建0-100000之间的随机数组
        int[] arr = new int[100000];
        for (int i = 0; i < 100000; i++) {
            arr[i] = (int) (Math.random() * 8000000); // 生成一个[0, 8000000) 数
        }
        //int[] arr = {101, 21, 40, 16, 113, 5, 18, 19, 7000, 1230};
        System.out.println("排序前的数组为" + Arrays.toString(arr));
        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("排序前的时间是=" + date1Str);

        int[] temp = new int[arr.length];
        radixSort(arr);

        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("排序前的时间是=" + date2Str);
        System.out.println("排序后的数组为" + Arrays.toString(arr));
    }


    /**
     * 基数排序
     *
     * @param arr 需要排序的数组
     */
    public static void radixSort(int[] arr) {

        //得到最大数的位数
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        int maxLength = (max + "").length();

        int[][] bucket = new int[arr.length][10];
        //每个桶中放的个数
        int[] bucketElementCounts = new int[10];
        for (int i = 1, n = 1; i <= maxLength; i++, n *= 10) {
            for (int j = 0; j < arr.length; j++) {
                //该位的数字
                int digitOfElement = arr[j] / n % 10;
                bucket[bucketElementCounts[digitOfElement]][digitOfElement] = arr[j];
                bucketElementCounts[digitOfElement]++;
            }

            int index=0;
            //遍历二维数组
            for (int k = 0; k < bucketElementCounts.length; k++) {
                if (bucketElementCounts[k]>0){
                    for (int t = 0; t < bucketElementCounts[k]; t++) {
                        arr[index] = bucket[t][k];
                        index++;
                    }
                }
                //每个桶中个数要清零,下一位重新计算,而二维数组不必清零,因为是先赋值再使用,会覆盖掉的,多余的也不会使用
                bucketElementCounts[k]=0;
            }

        }


    }
}
