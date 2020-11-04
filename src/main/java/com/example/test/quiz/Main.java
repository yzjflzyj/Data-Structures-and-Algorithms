package com.example.test.quiz;

import java.util.*;

public class Main {


       /*字符串重排
         题目描述
         给定一个只包含大写英文字母的字符串s，要求你给出对s重新排列的所有不相同的排列数。如：s为AAB，则不同的排列有ABA、AAB、BAA三种。
         输入
         输入一个长度不超过10的字符串，我们确保都是大写英文字母。
         输出
         输出所有不同的排列个数（包括自身）。
         样例1
         输入 ABA
         输出 3
         样例2
         输入 AABBCC
         输出 90*/

    static boolean[] visited = new boolean[10];
    static HashSet<String> result = new HashSet<String>();
    static int length;
    static StringBuilder tmp = new StringBuilder();
    static String str;

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

        
        while (sc.hasNext()) {
            str = sc.next();
            length = str.length();
            result.clear();
            tmp.delete(0, tmp.length());
            Arrays.fill(visited, false);
            getResult(1);
            for (String s : result) {
                System.out.println(s);
            }
            System.out.println(result.size());
        }


    }

    public static void getResult(int n) {

        if (n == length + 1) {
            result.add(tmp.toString());
        }

        for (int i = 0; i < length; i++) {

            if (!visited[i]) {
                tmp.append(str.charAt(i));
                visited[i] = true;
                getResult(n + 1);
                visited[i] = false;
                tmp.delete(tmp.length() - 1, tmp.length());
            }

        }
    }

      /*
        转换字符串的单词顺序
        String ans = "the sky is blue";
        String[] s = ans.split(" ");
        String reStr=s[s.length-1];

        for (int i = s.length-2; i>-1; i--) {
            reStr+=" "+s[i];
        }
        System.out.println(reStr);*/

}