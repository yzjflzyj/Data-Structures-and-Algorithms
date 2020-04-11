package com.example.test.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class MergeSort {
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

        int[] temp = new int[arr.length];
        mergeSort(arr, 0, 9, temp);

        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("排序前的时间是=" + date2Str);
        System.out.println("排序后的数组为" + Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            //向左递归
            mergeSort(arr, left, mid, temp);
            //向右递归
            mergeSort(arr, mid + 1, right, temp);
            //合并数组
            merge(arr, left, mid, right, temp);
        }

    }

    public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int leftIndex = left;
        int rightIndex = mid + 1;
        int index = left;
        while (leftIndex <= mid && rightIndex <= right) {
            if (arr[leftIndex] < arr[rightIndex]) {
                temp[index] = arr[leftIndex];
                leftIndex++;
            } else {
                temp[index] = arr[rightIndex];
                rightIndex++;
            }
            index++;
        }

        //两顺序数组一个已经遍历完,另一个就直接全部添加
        while (leftIndex <= mid) {
            temp[index] = arr[leftIndex];
            leftIndex++;
            index++;
        }
        while (rightIndex <= right) {
            temp[index] = arr[rightIndex];
            rightIndex++;
            index++;
        }

        //将temp已经排好的元素再复制回arr
        index=left;
        while (index <= right) {
            arr[index]=temp[index];
            index++;
        }
    }
}
