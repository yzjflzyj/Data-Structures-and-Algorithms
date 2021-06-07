package com.example.test.algorithms.quiz;

import java.util.HashMap;
import java.util.Map;

public class Test_3 {
    /*例题 1：判断数组中所有的数字是否只出现一次
【题目】 判断数组中所有的数字是否只出现一次。
给定一个个数字 arr，判断数组 arr 中是否所有的数字都只出现过一次。
约束时间复杂度为 O(n)。例如，arr = {1, 2, 3}，输出 YES。
又如，arr = {1, 2, 1}，输出 NO。*/

    /*例题 2：找出数组中出现次数超过数组长度一半的元素
【题目】 假设在一个数组中，有一个数字出现的次数超过数组长度的一半，现在要求你找出这个数字。
你可以假设一定存在这个出现次数超过数组长度的一半的数字，即不用考虑输入不合法的情况。
要求时间复杂度是 O(n)，空间复杂度是 O(1)。例如，输入 a = {1,2,1,1,2,4,1,5,1}，输出 1。*/

    /*例题 3：给定一个方格棋盘，从左上角出发到右下角有多少种方法;如图,迷宫的动态规划.png
【题目】 在一个方格棋盘里，左上角是起点，右下角是终点。每次只能向右或向下，移向相邻的格子。
同时，棋盘中有若干个格子是陷阱，不可经过，必须绕开行走。
要求用动态规划的方法，求出从起点到终点总共有多少种不同的路径。
例如，输入二维矩阵 m 代表棋盘，其中，1 表示格子可达，-1 表示陷阱。输出可行的路径数量为 2。*/

    public static void main(String[] args) {
        method1();

        method2();

        method3();
    }


    private static void method3() {

        int[][] m = {{1,1, 1, 1, 1,1}, {1,1,-1,-1,1,1}, {1,1,-1, 1,-1,1}};
        int path = getPath(m,2,5);
        System.out.println(path);
    }

    public static int getPath(int[][] m, int i, int j) {
        if (m[i][j] == -1) {
            return 0;
        }
        if ((i > 0) && (j > 0)) {
            return getPath(m, i-1, j) + getPath(m, i, j-1);
        }
        else if ((i == 0) && (j > 0)) {
            return getPath(m, i, j-1);
        }
        else if ((i > 0) && (j == 0)){
            return getPath(m, i-1, j);
        }
        else {
            return 1;
        }
    }

    /**
     * 相等则加一,不等则减一,次数为零则表明占一半.
     * 为-1时,则表明比一半少1,若是这个数,那么在后面的数组中,这个数个数仍然超过一半;
     * 若不是这个数,这个数占一半少一,那么应该的那个数在后面的数组中也要不少于一半.连同本身,也就是要超过一半.
     * 由于不管是不是这个数,在触发times为-1时,数组相当于重置,在后面的数组中重新开始比较,达到拆解数组的目的.
     *
     *切入思想是一半,一半相消之后,原有问题不变,数据规模却在缩小.
     *
     */
    private static void method2() {
        int[] a = {1,2,2,1,1,4,1,5,1};
        int result = a[0];
        int times = 1;
        for (int i = 1; i < a.length; i++) {
            if (a[i] != result) {
                times--;
            }
            else {
                times++;
            }
            if (times == -1) {
                times = 1;
                result = a[i];
            }
        }
        System.out.println(result);
    }

    private static void method1() {
        int[] arr = { 1, 2, 3,3 };
        boolean isUniquel = isUniquel(arr);
        if (isUniquel) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }


    public static boolean isUniquel(int[] arr) {
        Map<Integer, Integer> d = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (d.containsKey(arr[i])) {
                return false;
            }
            d.put(arr[i], 1);
        }
        return true;
    }
}
