package com.example.test.leetcode.JZOffer;
import java.util.Stack;

public class Test6 {
    public static void main(String[] args) {
       /*剑指 Offer 06. 从尾到头打印链表
         输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
         示例 1：
         输入：head = [1,3,2]
         输出：[2,3,1]
         限制：
         0 <= 链表长度 <= 10000*/
        //1.构造链表
        Node head = new Node(1);
        Node node1 = new Node(2);
        Node node2 = new Node(3);
        head.next=node1;
        node1.next=node2;
        node2.next=null;
        //2.用栈来存储节点
        Stack<Node> s=new Stack<Node>();
        Node temp = head;
        while(temp!=null){
            s.push(temp);
            temp=temp.next;
        }
        //3.将栈中节点数据放入数组
        int len=s.size();
        int[] arr=new int[len];
        for (int i = 0; i < len; i++) {
            arr[i]=s.pop().data;
        }

    }

    private static class Node {
        private Node next;
        private int data;

        public Node(int data) {
            this.data = data;
        }
    }
}
