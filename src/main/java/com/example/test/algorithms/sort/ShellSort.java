package com.example.test.algorithms.sort;

import com.example.test.algorithms.Utils.Utils;

public class ShellSort {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 6, 3, 5, 8, 9, 7, 0};
//        int[] arr = Utils.autoCreateArray(10, 10);
        Utils.timePrint(arr);
        shellSort(arr);
        Utils.timePrint(arr);
    }

    /**
     * 分组插入排序
     *
     * @param arr
     */
    public static void shellSort(int[] arr) {
        int insertVal;
        int index;
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            //分为gap个组,每个组的步长也为gap
            //使用插入排序
            for (int i = gap; i < arr.length; i++) {
                insertVal = arr[i];
                index = i - gap;
                while (index >= 0 && Utils.less(insertVal, arr[index])) {
                    arr[index + gap] = arr[index];
                    index -= gap;
                }
                //如果不需要往后插入,那么不再重复赋值
                if (index != i - gap) {
                    arr[index + gap] = insertVal;
                }

            }
        }
    }

}
