package com.example.test.algorithms.JZOffer;

public class Test11 {
    /*剑指 Offer 11. 旋转数组的最小数字
      把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。
      示例 1：输入：[3,4,5,1,2]输出：1
      示例 2：输入：[2,2,2,0,1]输出：0*/
    public static void main(String[] args) {
        int[] arr = {2,2,2,0,1};
        method2(arr);


    }

    private static void method1(int[] arr) {
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > arr[i + 1]) {
                index = i+1;
                break;
            }
        }
        System.out.println(arr[index]);
    }

    //二分法
    private static void method2(int[] arr) {
        int left=0,right=arr.length-1,mid;
        while (left<right){
            mid=(left+right)/2;
            if (arr[mid]>arr[right]){  //arr[mid]不和arr[left]比,是因为他们相等时,有可能是因为索引相等了,有干扰
                //最小值在中点(不包含)右边
                left=mid+1;
            }else if(arr[mid]<arr[right]){
                //最小值在中点(包含)左边
                right=mid;
            }else {
                //mid不可能等于right,有可能mid到right值均相等, 也可能最小值在中间,所以不能用right=mid,只能保证right不是唯一的最小值(可能不是最小值, 也可能是最小值,但是还有别的相等最小值),所以向左进一位
                right=mid;
            }
        }
        System.out.println(arr[left]);
    }
}
