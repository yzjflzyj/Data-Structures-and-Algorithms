package com.example.test.sort;

import com.example.test.Utils.Utils;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 6, 3, 5, 8, 9, 7, 0};
//        int[] arr = Utils.autoCreateArray(10, 10);
        Utils.timePrint(arr);
        quickSort(arr, 0, 9);
        if (Utils.isSorted(arr)) System.out.println("数组已经排好序了");
        Utils.timePrint(arr);
    }

    /**
     * 快速排序
     * @param arr
     * @param left
     * @param right
     */
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
            Utils.exch(arr,r,l);

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
        if (Utils.less(left , r)) {
            quickSort(arr, left, r);
        }

        //比pivot大的右边数组递归
        if (Utils.less(l,right)) {
            quickSort(arr, l, right);
        }

    }
}
