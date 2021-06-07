package com.example.test.algorithms.JZOffer;
import java.util.HashMap;
import java.util.Map;

public class Test7 {
      /*剑指 Offer 07. 重建二叉树
        输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
        例如，给出
        前序遍历 preorder = [3,9,20,15,7]
        中序遍历 inorder = [9,3,15,20,7]
        返回如下的二叉树：
                 3
                / \
               9  20
                 /  \
                15   7*/
      public static void main(String[] args) {
          int [] preorder = {3,9,20,15,7};
          int [] inorder = {9,3,15,20,7};
          method1(preorder,inorder);
      }


    private static Node method1(int[] preorder, int[] inorder) {
        //思路
        //1.通过【前序遍历列表】确定【根节点 (root)】
        //2.将【中序遍历列表】的节点分割成【左分支节点】和【右分支节点】
        //3.递归寻找【左分支节点】中的【根节点 (left child)】和 【右分支节点】中的【根节点 (right child)】
        int len=preorder.length;
        //记录中序遍历索引与指的对应关系
        Map<Integer, Integer> indexMap=new HashMap<Integer, Integer>();
        for (int i = 0; i < len; i++) {
            indexMap.put(inorder[i],i);
        }
        Node root = buildTree(preorder,inorder,0,len-1,0,len-1,indexMap);
        return root;
    }

    public static Node buildTree(int[] preorder, int[] inorder, int preorder_left, int preorder_right, int inorder_left, int inorder_right,Map<Integer, Integer> indexMap){
        if (preorder_left > preorder_right) {
            return null;
        }
        //根
        Node root = new Node(preorder[preorder_left]);
        //根节点在中序数组中的索引
        int index=indexMap.get(preorder[preorder_left]);
        //左子节点,中序的索引[inorder_left,index-1], 前序的索引[preorder_left+1,preorder_left+1+index-1-inorder_left]
        root.left=buildTree(preorder,inorder,preorder_left+1,preorder_left+1+index-1-inorder_left,inorder_left,index-1,indexMap);
        //右子节点,中序的索引[index+1,inorder_right],前序的索引[preorder_left+1+index-inorder_left,preorder_right]
        root.right=buildTree(preorder,inorder,preorder_left+1+index-inorder_left,preorder_right,index+1,inorder_right,indexMap);
        return root;
    }


 static class Node {
        private int data;
        private Node left; //默认null
        private Node right; //默认null

        public Node(int data) {
            this.data = data;
        }
    }
}
