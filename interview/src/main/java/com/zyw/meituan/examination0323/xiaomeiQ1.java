package com.zyw.meituan.examination0323;

import java.util.Scanner;

public class xiaomeiQ1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        //2 3
        //110
        //010
        in.nextLine();
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            String line = in.nextLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = line.charAt(j) - '0';
            }
        }
        int count = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < m - 1; j++) {
                if (is(arr,i,j)){
                    count++;
                }
            }
        }
        System.out.println(count);

    }

    private static boolean is(int[][] arr, int i, int j) {
        int ones = 0;
        for (int x = i; x <= i + 1; x++) {
            for (int y = j; y <= j + 1; y++) {
                if (arr[x][y] == 1) {
                    ones++;
                }
            }
        }
        return ones == 2;
    }
}
