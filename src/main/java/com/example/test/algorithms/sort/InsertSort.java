package com.example.test.algorithms.sort;

import com.example.test.algorithms.Utils.Utils;

public class InsertSort {
    public static void main(String[] args) {

        int[] arr = {1, 2, 4, 6, 3, 5, 8, 9, 7, 0};
//        int[] arr = Utils.autoCreateArray(10, 10);
        Utils.timePrint(arr);
        insertSort(arr);
        Utils.timePrint(arr);


    }

    /**
     * 插入排序
     *
     * @param arr
     */
    public static void insertSort(int[] arr) {
        int index;
        int insertVal;
        for (int i = 1; i < arr.length; i++) {
            index = i - 1;
            insertVal = arr[i];
            while (index >= 0 && Utils.less(insertVal, arr[index])) {
                arr[index + 1] = arr[index];
                index--;
            }
            //如果不需要往后插入,那么不再重复赋值
            if (index != i - 1) {
                arr[index + 1] = insertVal;
            }
        }

        if (Utils.isSorted(arr)) System.out.println("数组已经排好序了");
    }
}
