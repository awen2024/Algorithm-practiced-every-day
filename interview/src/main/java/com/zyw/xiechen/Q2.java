package com.zyw.xiechen;

import java.util.Scanner;

public class Q2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
//        in.nextLine();
        //3 3
        //111
        //111
        //111
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            String str = in.nextLine();
            for (int j = 0; j < m; j++) {
                if (str.charAt(j) == '1') {
                    arr[i][j] = 1;
                }
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m;j++) {
                if (arr[i][j] == 0 ) {
                    count++;
                    if (j + 1 < m && arr[i][j + 1] == 0) {
                        j++;
                    }
                }
            }
        }
        System.out.println("count = " + count);
    }
}
