package com.example.test.leetcode.JZOffer;

import java.util.Stack;

public class Test9 {
    public static void main(String[] args) {
        /*剑指 Offer 09. 用两个栈实现队列
          用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
          提示：
          1 <= values <= 10000
          最多会对 appendTail、deleteHead 进行 10000 次调用*/

        //思路:一个栈进,一个栈出
        Stack in = new Stack();
        Stack out = new Stack();
        appendTail(in, out, 1);
        appendTail(in, out, 2);
        appendTail(in, out, 3);
        int a = deleteHead(in, out);
        int b =deleteHead(in, out);
        int c =deleteHead(in, out);
        int d =deleteHead(in, out);
    }

    public static void appendTail(Stack in, Stack out, int e) {
        int len = out.size();
        for (int i = 0; i < len; i++) {
            in.push(out.pop());
        }
        in.push(e);
    }

    public static int deleteHead(Stack in, Stack out) {
        int len = in.size();
        for (int i = 0; i < len; i++) {
            out.push(in.pop());
        }
        return out.size() > 0 ? (int) out.pop() : -1;
    }
}
