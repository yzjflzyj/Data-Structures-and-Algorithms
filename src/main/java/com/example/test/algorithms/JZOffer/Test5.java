package com.example.test.algorithms.JZOffer;

public class Test5 {
   /* 剑指 Offer 05. 替换空格
    请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
    示例 1：
    输入：s = "We are happy."
    输出："We%20are%20happy."
    限制：0 <= s 的长度 <= 10000*/
   public static void main(String[] args) {
      method1();
      method2();
   }

   private static void method2() {
      String str="we   are happy";
      String newStr = str.replace(" ", "%20");
      System.out.println(newStr);
   }

   //字符数组
   // 时间复杂度：O(n)。遍历字符串 s 一遍。
   // 空间复杂度：O(n)。额外创建字符数组，长度为 s 的长度的 3 倍。
   private static void method1() {
      String str="we   are happy";
      int length = str.length();
      char[] chars = new char[length * 3];
      int size=0;
      for (int i = 0; i < length; i++) {
         char c = str.charAt(i);
         if (c==' '){
            chars[size++]='%';
            chars[size++]='2';
            chars[size++]='0';
         }else {
            chars[size++]=c;
         }
      }
      String newStr=new String(chars,0,size);
      System.out.println(newStr);
   }

}
