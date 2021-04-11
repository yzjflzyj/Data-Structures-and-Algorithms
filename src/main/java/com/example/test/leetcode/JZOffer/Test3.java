package com.example.test.leetcode.JZOffer;

import com.example.test.Utils.Utils;

import java.util.Arrays;
import java.util.HashSet;

public class Test3 {
    /*剑指 Offer 03. 数组中重复的数字
      找出数组中重复的数字。
      在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
      示例 1：
      输入：
      [2, 3, 1, 0, 2, 5, 3]
      输出：2 或 3

      限制：2 <= n <= 100000*/
    public static void main(String[] args) {
        method1();
        method2();
    }


    /**
     * @Author codeHu
     * @Description 利用hashset找到重复值
     * @Date 19:19 2021/4/11
     * @Param []
     * @return void
     **/
    private static void method2() {
        int[] arr = Utils.autoCreateArray(10, 9);
        System.out.println("当前数组为" + Arrays.toString(arr));
        Utils.timePrint("方法二开始:");
        HashSet hashSet = new HashSet();
        for (int i = 0; i < arr.length; i++) {
            if(!hashSet.contains(arr[i])){
                hashSet.add(arr[i]);
            }else{
                System.out.println("重复的其中一个数字是"+arr[i]);
                Utils.timePrint("方法二结束:");
                return;
            }
        }
    }

    /**
     * @Author codeHu
     * @Description 暴力比对,时间复杂度为O(n²),空间复杂度为O(n)
     * @Date 19:00 2021/4/11
     * @Param []
     * @return void
     **/
    private static void method1() {
        int[] arr = Utils.autoCreateArray(10, 9);
        System.out.println("当前数组为" + Arrays.toString(arr));
        Utils.timePrint("方法一开始:");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] == arr[j]) {
                    System.out.println("重复的其中一个数字是"+arr[i]);
                    Utils.timePrint("方法一结束:");
                    return;
                }
            }
        }
    }


}
