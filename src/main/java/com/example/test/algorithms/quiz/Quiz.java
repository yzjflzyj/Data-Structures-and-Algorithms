package com.example.test.algorithms.quiz;


import java.util.Scanner;

public class Quiz {
    public static void main(String[] args) {
        String a="I am a student";
        StringBuilder reverse = new StringBuilder(a).reverse();
        System.out.println(reverse);
        //printLastWord();
        int daffodil = daffodil();
    }

    /**
     * 水仙花
     * @return
     */
    private static int daffodil() {
        int n = 0;
        int m = 0;
        try {
            System.out.println("请输入位数n：");
            Scanner sc = new Scanner(System.in);
            n = Integer.parseInt(sc.nextLine());
            System.out.println("请输入第m个水仙花数：");
            m = Integer.parseInt(sc.nextLine());
            System.out.println("计算中。。。");
        } catch (NumberFormatException e) {
            System.out.println("输入不合法");
            return -1;
        }
        if (m<0 || n<0){
            System.out.println("输入不合法");
            return -1;
        }

        int count = -1;
        int lastNum=0;
        for (int i = (int) Math.pow(10, n - 1); i < (int) Math.pow(10, n); i++) {
            int sum = 0;
            for (int j = 1; j < n + 1; j++) {
                sum += Math.pow(i / ((int) Math.pow(10, j - 1)) % 10, n);
            }
            if (sum == i) {
                lastNum=i;
                count++;
            }
            if (count==m){
                System.out.printf("计算结果是%d",i);
                return i;
            }
        }
        if (count>=0){
            System.out.printf("计算结果是%d",m*lastNum);
            return m*lastNum;
        }else {
            System.out.println("没有水仙花数");
            return 0;
        }
    }

    /**
     * 打印最后一个单词（单词之间空格隔开）
     */
    private static void printLastWord() {
        String a = "hello world";
        String[] s = a.split(" ");
        System.out.println(s[s.length - 1]);
    }

     /*Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String s = str.toLowerCase();
        int len=str.length();
        int count=0;
        int max=0;
        for (int i = 0; i < len; i++) {
            if ("aeiou".indexOf(s.charAt(i))>-1){
                count++;
            }else {
                count=0;
            }
            if (max<count){
                max=count;
            }
        }
        System.out.println(max);*/

        /*int[] a = new int[50];
        a[0] = 1;
        a[1] = 2;
        a[2] = 4;
        for (int i = 3; i < 50; i++) {
            a[i] = a[i - 1] + a[i - 2] + a[i - 3];
            a[i]=a[i]%26;
        }
        String spe = "abcdefghijklmnopqrstuvwxyz";
        Scanner scn = new Scanner(System.in);
        Scanner scs = new Scanner(System.in);
        int n = scn.nextInt();
        for (int i = 0; i < n; i++) {
            String str = scs.nextLine().toLowerCase();
            String en = "";
            for (int j = 0; j < str.length() && j < a.length; j++) {
                int index = spe.indexOf(str.charAt(j));
                index = (index + a[j]) % spe.length();
                en += spe.charAt(index);
            }
            System.out.println(en);
        }*/

}
