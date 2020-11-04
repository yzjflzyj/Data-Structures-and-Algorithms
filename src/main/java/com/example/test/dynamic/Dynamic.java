package com.example.test.dynamic;

public class Dynamic {
    public static void main(String[] args) {
        //求最短路线
        questionOne();
        //求两字符串的最长公共子串
        questionTwo();
    }


    public static int minPath(int[][] matrix) {
        return process(matrix, matrix[0].length-1);
    }
    // 递归
    public static int process(int[][] matrix, int i) {
        // 到达A退出递归
        if (i == 0) {
            return 0;
        }
        // 状态转移
        else{
            int distance = 999;
            for(int j=0; j<i; j++){
                if(matrix[j][i]!=0){
                    int d_tmp = matrix[j][i] + process(matrix, j);
                    if (d_tmp < distance){
                        distance = d_tmp;
                    }
                }
            }
            return distance;
        }
    }


    public static void questionOne(){
        /*求路径最短的路线*/
        int[][] m = {{0,5,3,0,0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,1,3,6,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,8,7,6,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,6,8,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,3,5,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,3,3,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,8,4,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,2,2,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,1,2,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,3,3,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0,0,3,5,0},{0,0,0,0,0,0,0,0,0,0,0,0,0,5,2,0},{0,0,0,0,0,0,0,0,0,0,0,0,0,6,6,0},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,4},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,3}};
        System.out.println(minPath(m));
    }

    public static void questionTwo(){
        /*求两字符串的最长公共子串*/
        String a = "13452439";
        String b = "123456";
        getCommenStr(a, b);
    }
    public static void getCommenStr(String a, String b) {
        char[] c1 = a.toCharArray();
        char[] c2 = b.toCharArray();
        int[][] m = new int[c2.length+1][c1.length+1];
        for (int i = 1; i <= c2.length; i++) {
            for (int j = 1; j <= c1.length; j++) {
                if (c2[i - 1] == c1[j - 1])
                    m[i][j] = m[i - 1][j - 1] + 1;
            }
        }
        int max = 0;
        int index = 0;
        for (int i = 0; i <= c2.length; i++) {
            for (int j = 0; j <= c1.length; j++) {
                if (m[i][j] > max) {
                    max = m[i][j];
                    index = i;
                }
            }
        }
        String s = "";
        for (int i = index - max; i < index; i++)
            s += b.charAt(i);
        System.out.println(s);
    }

}
