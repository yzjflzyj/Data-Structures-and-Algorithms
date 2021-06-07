package com.example.test.algorithms.recursion;

public class Queue8 {

	//定义一个max表示共有多少个皇后
	int max = 8;
	//定义数组array, 保存皇后放置位置的结果,数组元素的索引即是该皇后的行数
	int[] array = new int[max];
	static int count = 0;
	static int judgeCount = 0;
	public static void main(String[] args) {
		Queue8 queue8 = new Queue8();
		queue8.check(0);
		System.out.printf("一共有%d解法", count);
		System.out.printf("一共判断冲突的次数%d次", judgeCount);
		
	}
	
	

	//从第n个(索引号)开始往后挨个位置(所在列的位置)试,不冲突则开始对下一个皇后的位置进行挨个位置(所在列的位置)尝试
	private void check(int n) {
		if(n == max) {  //n = 8 , 其实8个皇后就既然放好
			print();
			return;
		}
		
		//依次放入皇后，并判断是否冲突
		for(int i = 0; i < max; i++) {
			//先把当前这个皇后 n , 放到该行的第i列
			array[n] = i;
			//判断当放置第n个皇后到i列时，是否冲突,不冲突则继续放下一个皇后并去比较,冲突则换下一列继续试是否冲突
			if(judge(n)) { // 不冲突
				//接着放n+1个皇后,即开始递归
				check(n+1); //  
			}
		}
	}
	
	//查看当我们放置第n个皇后, 就去检测该皇后是否和前面已经摆放的皇后冲突
	/**
	 * 
	 * @param n 表示第n个皇后
	 * @return
	 */
	private boolean judge(int n) {
		judgeCount++;
		for(int i = 0; i < n; i++) {
			// 说明
			//1. array[i] == array[n]  表示判断 第n个皇后是否和前面的n-1个皇后在同一列
			//2. Math.abs(n-i) == Math.abs(array[n] - array[i]) 表示判断第n个皇后是否和第i皇后是否在同一斜线
			// n = 1  放置第 2列 1 n = 1 array[1] = 1
			// Math.abs(1-0) == 1  Math.abs(array[n] - array[i]) = Math.abs(1-0) = 1
			//3. 判断是否在同一行, 没有必要，n 每次都在递增
			if(array[i] == array[n] || Math.abs(n-i) == Math.abs(array[n] - array[i]) ) {
				return false;
			}
		}
		return true;
	}
	
	//写一个方法，可以将皇后摆放的位置输出
	private void print() {
		count++;
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}

}
