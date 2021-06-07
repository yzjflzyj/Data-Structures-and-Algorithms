package com.example.test.algorithms.tree;

import com.example.test.algorithms.Utils.Utils;


public class HeapSort {
    public static void main(String[] args) {
        int[] arr = new int[8000000];
        for (int i = 0; i < 8000000; i++) {
            arr[i] = (int) (Math.random() * 8000000);
        }
//        int[] arr = {4, 6, 8, 5, 9};
        Utils.timePrint(arr);

        heapSort(arr);

        Utils.timePrint(arr);
    }

    /**
     * @param arr 需要排序的数组
     */
    public static void heapSort(int arr[]) {
        int temp = 0;

        //循环保证了大顶锥的总体趋势,因此之后互换再调整时不需要循环,只需要每层树进行调整即可,少一次循环.
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }


        for (int j = arr.length - 1; j > 0; j--) {
            temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            adjustHeap(arr, 0, j);
        }

        if (Utils.isSorted(arr)) System.out.println("数组已经排好序了");

    }


    /**
     * 调整为大顶锥
     *
     * @param arr    数组
     * @param i      数组需要排序的起始索引
     * @param length 数组需要排序的末尾索引
     */
    public static void adjustHeap(int arr[], int i, int length) {

        int temp = arr[i];
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            if (k + 1 < length && arr[k] < arr[k + 1]) {
                k++;
            }
            if (arr[k] > temp) {
                arr[i] = arr[k];
                i = k;
            } else {
                break;
            }
        }
        arr[i] = temp;
    }
}
