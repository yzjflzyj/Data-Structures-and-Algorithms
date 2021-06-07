package com.example.test.algorithms.sort;

import com.example.test.algorithms.Utils.Utils;

public class SelectSort {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 6, 3, 5, 8, 9, 7, 0};
//        int[] arr = Utils.autoCreateArray(10, 10);
        Utils.timePrint(arr);
        selectSort(arr);
        Utils.timePrint(arr);
    }

    /**
     * 选择排序
     * @param arr
     */
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
        if (Utils.isSorted(arr)) System.out.println("数组已经排好序了");
    }
}
