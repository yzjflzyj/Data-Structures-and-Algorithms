package com.example.test.quiz;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Test_1 {
    /*流式输入,每次输入一个数,输出对应的中位数,偶数个时输入靠左边的数*/
    //运用大小顶锥,帮助维护左右两组数,左边用大顶锥,右边用小顶锥,即左边维护一个左边的最大值,右边维护右边的最小值,从而找出中位数,
    // 还有一个条件是左边的小于右边的,那么可以让每次的数据流入,都经过一边到达另一边,即右边最小的流到左边,左边最大的流到右边就能实现这一条件
    int count = 0;
    static PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    static PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2.compareTo(o1);
        }
    });
    public void Insert(Integer num) {
        if (count % 2 == 0) {
            minHeap.offer(num);
            maxHeap.offer(minHeap.poll());
        } else {
            maxHeap.offer(num);
            minHeap.offer(maxHeap.poll());
        }
        count++;
        System.out.println(Test_1.GetMedian());
    }
    public static int GetMedian() {
        return maxHeap.peek();
    }
    public static void main(String[] args) {
        Test_1 t = new Test_1();
        t.Insert(1);
        t.Insert(2);
        t.Insert(0);
        t.Insert(20);
        t.Insert(10);
        t.Insert(22);
    }
}