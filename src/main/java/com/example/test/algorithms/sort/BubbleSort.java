package com.example.test.algorithms.sort;

import com.example.test.algorithms.Utils.Utils;

public class BubbleSort {
    public static void main(String[] args) {

//        int[] arr = {1, 2, 4, 6, 3, 5, 8, 9, 7, 0};
        int[] arr = Utils.autoCreateArray(10, 10);
        Utils.timePrint(arr);
        bubbleSort(arr);
        Utils.timePrint(arr);
    }

    /**
     * 冒泡排序
     *
     * @param arr
     */
    public static void bubbleSort(int[] arr) {
        //使用冒泡排序
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i; j++) {
                if (Utils.less(arr[j + 1], arr[j])) {
                    Utils.exch(arr, j + 1, j);
                }
            }
        }

        if (Utils.isSorted(arr)) System.out.println("数组已经排好序了");
    }
}
