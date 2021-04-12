package com.example.test.leetcode.JZOffer;

public class Test4 {
    public static void main(String[] args) {
/*      剑指 Offer 04. 二维数组中的查找
        在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，
        输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
        示例:
        现有矩阵 matrix 如下：
        [
          [1,   4,  7, 11, 15],
          [2,   5,  8, 12, 19],
          [3,   6,  9, 16, 22],
          [10, 13, 14, 17, 24],
          [18, 21, 23, 26, 30]
        ]
        给定 target = 5，返回 true。
        给定 target = 20，返回 false。
        限制：
        0 <= n <= 1000
        0 <= m <= 1000*/

        //造数
        int target=5;
        int [][] matrix=new int [5][5];
        matrix[0]=new int[]{1,4,7,11,15};
        matrix[1]=new int[]{2,5,8,12,19};
        matrix[2]=new int[]{3,6,9,16,22};
        matrix[3]=new int[]{10,13,14,17,24};
        matrix[4]=new int[]{18,21,23,26,30};

        method1(matrix,target);
        //另一种方法是暴力算法, 直接遍历整个二维数组
    }

    /**
     * @Author codeHu
     * @Description 
     * @Date 15:43 2021/4/12
     * @Param []
     * @return void
     **/
    private static void method1(int[][] matrix,int target) {
        //分析:
        //根据矩阵特性,
        //1.先找到比目标数小的,然后再逐渐增大的比,即1.1列数减小,行数增大的顺序比       或者      1.2行数减小,列数增大的顺序比;
        //2.先找到比目标数大的,然后再逐渐减小的比,即2.1列数增大,行数减小的顺序比       或者      2.2行数增大,列数减小的顺序比;
        //在此选择2.1 先找比目标数大的,再减小的比, 列数逐渐增大,行数逐渐减小.
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        int rows=matrix.length;
        int columns=matrix[0].length;
        int row=rows-1,column=0;
        int element;
        boolean flag=false;
        while(row>=0 && row<rows && column>=0 && column<columns){
            element=matrix[row][column];
            if(target==element){
                flag=true;
                break;
            }else if(element>target){
                row--;
            }else{
                column++;
            }
        }
        if(flag){
            System.out.println("存在该数");
        }else{
            System.out.println("不存在该数");
        }
    }
}
