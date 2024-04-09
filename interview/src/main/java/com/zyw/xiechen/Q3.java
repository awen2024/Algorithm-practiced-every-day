package com.zyw.xiechen;

import java.util.Map;
import java.util.Scanner;

public class Q3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        long total = 0;
        int maxmin = Integer.MAX_VALUE;
        for (int i : arr) {
            total += i;
            maxmin = Math.min(maxmin, i);
        }
        if (maxmin >= 0) {
            System.out.println(total - maxmin / 2);
            return;
        }
        long compare = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] % 2 == 0 && arr[i] < 0) {
                int j = i;
                long sum = arr[j];
                long min = arr[j];
                j++;
                //往后搜索
                while (j < n && arr[j] % 2 == 0 && sum < 0) {
                    sum += arr[j];
                    min = Math.min(min, arr[j]);
                    min = Math.min(min, sum);
                    j++;
                }
                i = j;
                compare = Math.min(compare, min);
            }
        }
        System.out.println(total - compare / 2);
    }
}
