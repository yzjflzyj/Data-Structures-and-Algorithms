package com.example.test.algorithms.quiz;

import java.util.Scanner;

public class MoveChar {
    /*输入的字符串中*号放在字符串前面,如"*q*we" 变为"**qwe"*/
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] arr=new String[str.length()];
        arr[0]= String.valueOf(str.charAt(0));
        int index;
        String insertVal;
        for (int i = 0; i < arr.length; i++) {
            arr[i]=String.valueOf(str.charAt(i));
        }
        for (int i = 1; i < arr.length; i++) {
            index = i - 1;
            insertVal = arr[i];
            while (index>=0 && insertVal.equals("*") && !arr[index].equals("*")){
                arr[index+1]=arr[index];
                index--;
            }
            if (index!=i-1){
                arr[index+1]=insertVal;
            }
        }
        String result="";
        for (int i = 0; i < arr.length; i++) {
            result+=arr[i];
        }
        System.out.println(result);
    }
}
