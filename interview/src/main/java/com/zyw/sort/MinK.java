package com.zyw.sort;

import java.util.PriorityQueue;

public class MinK{
    public static Integer[] findTopKSmallestElements(Integer[] arr, int K) {
        // 使用默认的PriorityQueue，无需修改，它是一个最小堆
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (Integer num : arr) {
            minHeap.add(num);
        }
        Integer[] res = new Integer[K];
        for (int i = 0; i < K; i++) {
            if (!minHeap.isEmpty()) {
                res[i] = minHeap.poll();
            }
        }
        return res;
    }
}
