package com.example.test.leetcode.JZOffer;

public class Test16 {
    /*剑指 Offer 16. 数值的整数次方
      实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。不得使用库函数，同时不需要考虑大数问题。
      示例 1：输入：x = 2.00000, n = 10  输出：1024.00000
      示例 2：输入：x = 2.10000, n = 3  输出：9.26100
      示例 3：输入：x = 2.00000, n = -2  输出：0.25000  解释：2-2 = 1/22 = 1/4 = 0.25
      提示：-100.0 < x < 100.0  -231 <= n <= 231-1  -104 <= xn <= 104*/
    public static void main(String[] args) {

        method2(2,10);
        try {
            method1(2.0, 10);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }



    /***
     * @Author codeHu
     * @Description 暴力算法
     * @Date 10:47 2021/4/19
     * @Param [x, n]
     * @return double
     **/
    private static double method1(double x, int n) throws Exception {
        double res = 1.0;
        if (n > 0) {
            for (int i = 0; i < n; i++) {
                res = res * x;
            }
        } else if (n < 0) {
            for (int i = 0; i < -n; i++) {
                res = res * x;
            }
            res = 1 / res;
        } else {
            if (x == 0) {
                throw new Exception("0的0次方,没有意义");
            } else {
                res = 1;
            }
        }

        return res;
    }


    //快速幂法,降低时间复杂度,将时间复杂度降低至 O(log_2 n)O(log)
    //快速幂法:二进制, 将n转为二级制数,n=∑bi*2^(i-1),bi为n的二级制数从右开始的第i为数,为0或者1.
    //快速幂法:二分法,与二级制法类似
    private static double method2(double x,int n) {
        if(x == 0) return 0;
        long b = n;
        double res = 1.0;
        if(b < 0) {      //此处将n由负数变正数,int32的范围是[-2^31,2^31-1],变为正数之后范围就超了,因此需要变为long
            x = 1 / x;
            b = -b;
        }
        int count=0;
        while(b > 0) {
            if((b & 1) == 1) res *= x;  //当 n&1==1时,即二进制最后一位为1,判断奇偶性
            b >>= 1;    //等价于n//2,向下取整, 即右移一位(位移操作会默认转为二进制的)
        }
        return res;
    }

}
