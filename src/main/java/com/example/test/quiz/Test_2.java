package com.example.test.quiz;

public class Test_2 {
    /*【题目1】 给定一个排序数组，你需要在原地删除重复出现的元素，
    使得每个元素只出现一次，返回移除后的数组和新的长度，你不需要考虑数组中超出新长度后面的元素。
    要求：空间复杂度为 O(1)，即不要使用额外的数组空间。
    例如，给定数组 nums = [1,1,2]，函数应该返回新的长度 2，
    并且原数组 nums 的前两个元素被修改为 1, 2。
    又如，给定 nums = [0,0,1,1,1,2,2,3,3,4]，函数应该返回新的长度 5，
    并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。

    【题目2】 两个有序数组查找合并之后的中位数。给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
    请你找出这两个正序数组合在一起之后的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
    你可以假设 nums1 和 nums2 不会同时为空，所有的数字全都不相等。
    还可以再假设，如果数字个数为偶数个，中位数就是中间偏左的那个元素。
    例如：nums1 = [1, 3, 5, 7, 9]
    nums2 = [2, 4, 8, 12]
    输出 5。*/

    public static void main(String[] args) {
        /*方法一*/
        method1_1();

        /*方法二*/
        method1_2();




        
    }

    /**
     * 题目1解法1
     * 对数组进行移动,记录重复个数,以确定每次需要移动的索引范围
     */
    private static void method1_1() {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int repeatCount=0;
        for (int i = 1; i < nums.length-repeatCount; i++) {
                while (i>0 && nums[i]==nums[i-1]){
                    repeatCount++;
                    for (int j = i; j < nums.length-repeatCount; j++) {
                        nums[j]=nums[j+1];
                    }
                    i--;
                }
        }
        System.out.println("新数组长度"+(nums.length-repeatCount));
        System.out.println("新数组是");
        for (int i = 0; i < nums.length-repeatCount; i++) {
            System.out.print(nums[i]+" ");
        }
    }

    /**
     * 题目1解法2
     * 记录不等的个数,直接赋值已经知道的不等的个数
     */
    private static void method1_2() {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int temp = nums[0];
        int len = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != temp) {
                nums[len] = nums[i];
                temp = nums[i];
                len++;
            }
        }
        System.out.println(len);
        for (int i = 0; i < len; i++) {
            System.out.println(nums[i]);
        }
    }
}
