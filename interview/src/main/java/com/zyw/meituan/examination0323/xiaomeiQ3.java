package com.zyw.meituan.examination0323;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class xiaomeiQ3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        in.nextLine();
        String colors = in.nextLine();
        //存储红色元素
        ArrayList<Integer> reds = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (colors.charAt(i) == 'R') {
                reds.add(arr[i]);
            }
        }
        Collections.sort(reds);
        int red = 0;
        for (int i = 0; i < n; i++) {
            if (colors.charAt(i) == 'R') {
                arr[i] = reds.get(red++);
            }
        }
    }
}
