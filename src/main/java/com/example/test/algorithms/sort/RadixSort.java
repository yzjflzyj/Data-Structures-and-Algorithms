package com.example.test.algorithms.sort;

import com.example.test.algorithms.Utils.Utils;

public class RadixSort {
    public static void main(String[] args) {

        int[] arr = {1, 2, 4, 6, 3, 5, 8, 9, 7, 0};
//        int[] arr = Utils.autoCreateArray(10, 10);
        Utils.timePrint(arr);
        int[] temp = new int[arr.length];
        radixSort(arr);
        if (Utils.isSorted(arr)) System.out.println("数组已经排好序了");
        Utils.timePrint(arr);
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

            int index = 0;
            //遍历二维数组
            for (int k = 0; k < bucketElementCounts.length; k++) {
                if (bucketElementCounts[k] > 0) {
                    for (int t = 0; t < bucketElementCounts[k]; t++) {
                        arr[index] = bucket[t][k];
                        index++;
                    }
                }
                //每个桶中个数要清零,下一位重新计算,而二维数组不必清零,因为是先赋值再使用,会覆盖掉的,多余的也不会使用
                bucketElementCounts[k] = 0;
            }

        }


    }
}
