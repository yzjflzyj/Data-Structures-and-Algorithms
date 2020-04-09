package com.example.test.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class QuickSort {
    public static void main(String[] args) {
        //创建0-100000之间的随机数组
        int[] arr = new int[1000000];
        for (int i = 0; i < 1000000; i++) {
            arr[i] = (int) (Math.random() * 8000000); // 生成一个[0, 8000000) 数
        }
        //int[] arr = {1, 2, 4, 6, 3, 0, 8, 9, 7, 5};

        System.out.println("排序前的数组为" + Arrays.toString(arr));
        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("排序前的时间是=" + date1Str);

        quickSort(arr, 0, 9);

        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("排序前的时间是=" + date2Str);
        System.out.println("排序后的数组为" + Arrays.toString(arr));
    }

    private static void quickSort(int[] arr, int left, int right) {
        int l = left;
        int r = right;
        int temp = 0;
        //pivot 中轴值
        int pivot = arr[(left + right) / 2];

        while (l < r) {
            while (arr[r] > pivot) {
                r--;
            }

            while (arr[l] < pivot) {
                l++;
            }

            if (l >= r) {
                break;
            }

            //对于左边大于等于pivot,右边小于等于pivot的值进行交换位置(等于也会交换)
            temp = arr[r];
            arr[r] = arr[l];
            arr[l] = temp;

            if (arr[r] == pivot) {
                //交换前左边等于pivot,右边小于pivot,交换后左边要后移一个
                l++;
            }

            if (arr[l] == pivot) {
                //交换前右边边等于pivot,右边小于pivot,交换后左边要后移一个
                r--;
            }

        }

        //准备左右分组分别递归去快排的时候,中轴值是不参与的,不然数组的交换,在两个组中会干扰,会栈溢出
        if (l == r) {
            l++;
            r--;
        }
        //比pivot小的左边数组递归
        if (left < r) {
            quickSort(arr, left, r);
        }

        //比pivot大的右边数组递归
        if (right > l) {
            quickSort(arr, l, right);
        }

    }
}
