package com.zyw.sort;

import java.util.PriorityQueue;

public class TopK {

    public  static Integer[] findTopK(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(k);
        for (int num : arr) {
            if (pq.size() < k) {
                pq.add(num);
            } else if (num > pq.peek()) {
                //移除堆顶元素
                pq.poll();
                pq.add(num);
            }
        }
        Integer[] res = new Integer[k];
        int idx = 0;
        for (Integer num : pq) {
            res[idx] = num;
            idx++;
        }
        return res;
    }
}
