package com.example.test.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 6, 3, 5, 8, 9, 7, 0,1, 2, 4, 6, 3, 5, 8, 9, 7, 0};
        Arrays.sort(arr);
        int key=10;
//        int index = rank(key, arr, 0, arr.length-1);
//        if (index==-1) System.out.println("没有找到该元素");
//        else System.out.printf("查找到的数组下标是%d",index);
        List<Integer> resIndexList = rank2(key, arr, 0, arr.length - 1);
        if (resIndexList.size()==0) System.out.println("没有找到该元素");
        else System.out.println("查找到的数组下标是"+resIndexList.toString());
    }

    /**
     * 二分查找,返回查找元素的下标值
     * @param
     * key
     * @param arr
     * @return
     */
    private static int rank(int key, int[] arr,int lo,int hi) {
        if (lo<=hi){
            int mid=(lo+hi)/2;
            if (key<arr[mid]) {
                hi=mid-1;
                return rank(key, arr, lo, hi);
            }
            else if (key>arr[mid]) {
                lo=mid+1;
                return rank(key, arr, lo, hi);
            } else {
                return mid;
            }
        }
        return -1;

    }

    /**
     * 二分查找,返回查找元素的下标集合
     * @param key
     * @param arr
     * @param lo
     * @param hi
     * @return
     */
    private static List<Integer> rank2(int key, int[] arr, int lo, int hi) {
        if (lo<=hi){
            int mid=(lo+hi)/2;
            if (key<arr[mid]) {
                hi=mid-1;
                return rank2(key, arr, lo, hi);
            }
            else if (key>arr[mid]) {
                lo=mid+1;
                return rank2(key, arr, lo, hi);
            } else {
                List  resIndexList= new ArrayList<Integer>();
                //向左寻找最小的索引
                for (int i=mid-1;i>=0 && arr[i]==arr[mid];i--)resIndexList.add(i);
                //保证索引的顺序
                resIndexList.add(mid);
                //向右寻找最大索引
                for (int i=mid+1;i<arr.length-1 && arr[i]==arr[mid];i++)resIndexList.add(i);
                return resIndexList;

            }
        }
        return new ArrayList<Integer>();

    }
}
