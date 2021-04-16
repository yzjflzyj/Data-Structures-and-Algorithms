package com.example.test.leetcode.JZOffer;

public class Test15 {
    /*剑指 Offer 15. 二进制中1的个数
      请实现一个函数，输入一个整数（以二进制串形式），输出该数二进制表示中 1 的个数。例如，把 9 表示成二进制是 1001，有 2 位是 1。因此，如果输入 9，则该函数输出 2。
      示例 1：输入：00000000000000000000000000001011 输出：3 解释：输入的二进制串 00000000000000000000000000001011 中，共有三位为 '1'。
      示例 2：输入：00000000000000000000000010000000 输出：1 解释：输入的二进制串 00000000000000000000000010000000 中，共有一位为 '1'。
      示例 3：输入：11111111111111111111111111111101 输出：31 解释：输入的二进制串 11111111111111111111111111111101 中，共有 31 位为 '1'。
      提示：输入必须是长度为 32 的 二进制串 。*/
    public static void main(String[] args) {
        int n = 00000000000000000000000000001011;
        System.out.println(method1(n));
        System.out.println(method2(n));


    }

    //思路:n-1会将n的最后一个1及其后面的0(如xxx100),取反(变为xx011),因此n-1再和n去与之后,n最后的一个1就会变为0
    //注: n+1,会将n的最后一个0及其之后的1,取反
    private static int method1(int n) {
        int count = 0;
        while (n != 0) {
            n = n & (n - 1);
            count++;
        }
        return count;
    }


    //思路:  树状数组题目中有个lowbit(n)操作,lowbit(n)=n&(-n),即n&(~n+1),二级制的负数就是取反加一
    //      表示取得n的最后一个1及其后面的0的二进制数(n为二级制数,~n为取反),可以用n-lowbit(n)
    private static int method2(int n) {
        int count = 0;
        while (n != 0) {
            n -= n & (-n);
            count++;
        }
        return count;
    }
}
