package com.example.test.algorithms.JZOffer;

public class Test12 {
    /*剑指 Offer 12. 矩阵中的路径
      给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
      单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
      例如，在下面的 3×4 的矩阵中包含单词 "ABCCED"（单词中的字母已标出）。图 :Test12.png
      示例 1：输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"   输出：true
      示例 2：输入：board = [["a","b"],["c","d"]], word = "abcd"    输出：false
      提示：
      1 <= board.length <= 200
      1 <= board[i].length <= 200
      board 和 word 仅由大小写英文字母组成*/
    public static void main(String[] args) {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCCED";
        if (method(board, word))
            System.out.println("找到了");
        else
            System.out.println("没有找到");

    }

    private static boolean method(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        char[] chs = word.toCharArray();
        boolean[][] isVisited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (def(board, i, j, isVisited, chs, 0)) return true;
            }
        }
        return false;
    }

    private static boolean def(char[][] board, int i, int j, boolean[][] isVisited, char[] chs, int index) {
        //递归终止条件(1,2条件不能错,否则可能出现数组指针越界异常)
        //1.走通了
        if (index == chs.length) {
            return true;
        }
        //2.走不通:碰壁即i,j越界,或者已经访问过,或者不相等
        if (i < 0 || i == board.length || j < 0 || j == board[0].length || isVisited[i][j] || board[i][j] != chs[index]) {
            return false;
        }
        //为了不重复比对,上一个比对的节点标记对后面节点的比对进行限制,后面节点比对完,要取消标记
        isVisited[i][j]=true;
        //递归,上下左右
        boolean res= def(board, i-1, j, isVisited, chs, index+1)||def(board, i+1, j, isVisited, chs, index+1)||
                def(board, i, j-1, isVisited, chs, index+1)||def(board, i, j+1, isVisited, chs, index+1);
        isVisited[i][j]=false;
        return res;
    }
}
