package com.zyw.xiaohongshu;

import java.util.Scanner;

public class shareQ2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int T = in.nextInt();   //时间上限
        int H = in.nextInt();   //精力上限
        int[] time = new int[n];
        int[] energy = new int[n];
        long[] happiness = new long[n];
        for (int i = 0; i < n; i++) {
            time[i] = in.nextInt();
            energy[i] = in.nextInt();
            happiness[i] = in.nextInt();
        }
        //如果不选择第i个事件：dp[i][j][k] = dp[i-1][j][k]
        //如果选择第i个事件：dp[i][j][k] = dp[i-1][j-t[i]][k-h[i]] + a[i]
        long[][][] dp = new long[n + 1][T + 1][H + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= T; j++) {
                for (int k = 0; k <= H; k++) {
                    //不选择第i个事件
                    dp[i][j][k] = dp[i - 1][j][k];
                    //选择第i个事件
                    if (j >= time[i - 1] && k >= energy[i - 1]) {
                        dp[i][j][k] = Math.max(dp[i][j][k], dp[i - 1][j - time[i - 1]][k - energy[i - 1]] + happiness[i - 1]);
                    }
                }
            }
        }
        System.out.println(dp[n][T][H]);

    }
}
