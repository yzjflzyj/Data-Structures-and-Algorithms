package com.example.test.sort;

import com.example.test.Utils.Utils;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 6, 3, 5, 8, 9, 7, 0};
//        int[] arr = Utils.autoCreateArray(10, 10);
        Utils.timePrint(arr);
        int temp[] = new int[arr.length];
        mergeSort(arr, 0, 9, temp);
        if (Utils.isSorted(arr)) System.out.println("数组已经排好序了");
        Utils.timePrint(arr);
    }

    /**
     * 归并排序
     * @param arr 需要排序的数组
     * @param left 需要排序的左索引
     * @param right 需要排序的左索引
     * @param temp  工具数组
     */
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
