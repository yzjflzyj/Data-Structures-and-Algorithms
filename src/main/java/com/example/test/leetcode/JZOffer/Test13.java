package com.example.test.leetcode.JZOffer;

public class Test13 {
    /*剑指 Offer 13. 机器人的运动范围
      地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，
      它每次可以向左、右、上、下移动一格（不能移动到方格外），
      也不能进入行坐标和列坐标的数位之和大于k的格子。
      例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。
      请问该机器人能够到达多少个格子？
      示例 1：输入：m = 2, n = 3, k = 1  输出：3
      示例 2：输入：m = 3, n = 1, k = 0  输出：1
      提示：
      1 <= n,m <= 100
      0 <= k <= 20*/
    public static void main(String[] args) {
        int m = 2, n = 3, k = 1, num = 0;
        boolean[][] isVisited = new boolean[m][n];
        if (m >= 0 && m <= 100 && n >= 0 && n <= 100) {
            num=method(m, n, 0, 0, k, num, isVisited);
            System.out.println(num);
        }else{
            System.out.println("请输入正确的m,n值");
        }

    }

    private static int method(int m, int n, int x, int y, int k, int num, boolean[][] isVisited) {
        int count = getcount(x) + getcount(y);  //坐标求和
        //递归终止条件
        if (x < 0 || x == m || y < 0 || y == n || count > k || isVisited[x][y]) {
            return num;
        }
        //进入递归
        if (!isVisited[x][y] && count <= k) {
            isVisited[x][y] = true;
            num++;
            //递归,上下左右
            num = method(m, n, x, y - 1, k, num, isVisited);
            num = method(m, n, x, y + 1, k, num, isVisited);
            num = method(m, n, x - 1, y, k, num, isVisited);
            num = method(m, n, x + 1, y, k, num, isVisited);
        }
        return num;
    }

    private static int getcount(int x) {
        return x / 100 + x % 100 / 10 + x % 10;
    }
}
