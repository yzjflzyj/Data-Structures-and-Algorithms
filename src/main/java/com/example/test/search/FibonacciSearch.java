package com.example.test.search;

import java.util.Arrays;

public class FibonacciSearch {

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 6, 3, 5, 8, 9, 7, 0, 1, 2, 4, 6, 3, 5, 8, 9, 7, 0};
        Arrays.sort(arr);
        int key = 9;
        int index = fibonacciSearch(key, arr,20);
        if (index == -1) System.out.println("没有找到该元素");
        else System.out.printf("查找到的数组下标是%d", index);
    }

    public static int fibonacciSearch(int key, int[] arr,int maxSize) {
        int[] fib = fib(maxSize);
        int k=0;
        int mid = 0; //存放mid值
        int lo=0;
        int hi=arr.length-1;
        while (hi>fib[k]-1){
            k++;
        }

        int[] temp = Arrays.copyOf(arr, fib[k]);
        for(int i = hi + 1; i < temp.length; i++) {
            temp[i] = arr[hi];
        }

        while (lo <= hi) {
            mid = lo + fib[k - 1]-1;
            if(key < temp[mid]) {
                //递归的时候要排除mid这个点(下面lo = mid+1同理),以此斐波那锲数列需要每次减一
                //即(fib[k]-1)=(fib[k-1]-1)+(fib[k-2]-1)+1 ,每次循环排除mid这个点,继续递归
                hi = mid-1;
                k--;
            } else if ( key > temp[mid]) {
                lo = mid+1;
                k -= 2;
            } else {
                if(mid <= hi) {
                    return mid;
                } else {
                    return hi;
                }
            }
        }
        return -1;


    }

    public static int[]  fib(int maxSize){
        int[] fib = new int[maxSize];
        fib[0]=1;
        fib[1]=1;
        for (int i = 2; i < maxSize; i++) {
            fib[i]=fib[i-1]+fib[i-2];
        }
        return fib;
    }
}
