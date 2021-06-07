package com.example.test.algorithms.JZOffer;

public class Test10_2 {
    /*剑指 Offer 10- II. 青蛙跳台阶问题
    一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个n级的台阶总共有多少种跳法。
    答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
    示例 1：输入：n = 2 输出：2
    示例 2：输入：n = 7 输出：21
    示例 3：输入：n = 0 输出：1
    提示：0 <= n <= 100*/

    public static void main(String[] args) {
        System.out.println(Fibonacci(10));
    }

    //思路, 用斐波那锲递归,缺点是有重复计算,在10_2中使用动态规划
    //循环取模(x+y)⊙p=(x⊙p+y⊙p)⊙p

    /*取模的原因:
    大数相乘，大数的排列组合等为什么要取模
    1000000007是一个质数（素数），对质数取余能最大程度避免结果冲突/重复
    int32位的最大值为2147483647，所以对于int32位来说1000000007足够大。
    int64位的最大值为2^63-1，用最大值模1000000007的结果求平方，不会在int64中溢出。
    所以在大数相乘问题中，因为(a∗b)%c=((a%c)∗(b%c))%c，所以相乘时两边都对1000000007取模，再保存在int64里面不会溢出。*/
    private static int Fibonacci(int n) {
        int a=1,b=1;
        int sum;
        for (int i = 0; i < n; i++) {
            sum=(a+b)%1000000007;
            a=b;
            b=sum;
        }
        return a;
    }
}
