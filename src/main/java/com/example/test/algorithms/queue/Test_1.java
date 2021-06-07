package com.example.test.algorithms.queue;

import java.util.LinkedList;

public class Test_1 {
    /*队列题目1,让图中二叉树,逐行从左至右输出*/
    /*因为没有逆序出现,队列的特性就是顺序*/

    public static void main(String[] args) {
        Node root=createTree();
        levelTraverse(root);
    }

    /**
     * 建树
     * @return
     */
    private static Node createTree() {
        Node node1 = new Node(16);
        Node node2 = new Node(13);
        Node node3 = new Node(20);
        Node node4 = new Node(10);
        Node node5 = new Node(15);
        Node node6 = new Node(22);
        Node node7 = new Node(21);
        Node node8 = new Node(26);
        node1.leftChild = node2;
        node1.rightChild = node3;
        node2.leftChild = node4;
        node2.rightChild = node5;
        node3.rightChild = node6;
        node6.leftChild = node7;
        node6.rightChild = node8;
        return node1;
    }

    public static void levelTraverse(Node root) {
        if (root == null) {
            return;
        }
        LinkedList<Node> queue = new LinkedList<Node>();
        Node current = null;
        queue.offer(root); // 根节点入队
        while (!queue.isEmpty()) { // 只要队列中有元素，就可以一直执行，非常巧妙地利用了队列的特性
            current = queue.poll(); // 出队队头元素
            System.out.print("-->" + current.data);
            // 左子树不为空，入队
            if (current.leftChild != null)
                queue.offer(current.leftChild);
            // 右子树不为空，入队
            if (current.rightChild != null)
                queue.offer(current.rightChild);
        }
    }


    public static class Node {
        private int data;
        private Node leftChild;
        private Node rightChild;

        public Node(int data) {
            this.data = data;
        }
    }
}
