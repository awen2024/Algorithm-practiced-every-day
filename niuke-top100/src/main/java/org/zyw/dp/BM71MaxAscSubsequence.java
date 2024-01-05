package org.zyw.dp;


import java.util.Arrays;

public class BM71MaxAscSubsequence {
    public int maxAscSubseq(int[] arr) {
        int len = arr.length;
        if (len==0) return 0;
        int[] dp = new int[len + 1];
        int res = 1;
        Arrays.fill(dp, 1);
        dp[0] = 0;
        for (int i = 1; i <= len; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[i - 1] > arr[j - 1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    res = Math.max(res, dp[i]);
                }
            }
        }
        return res;
    }
}
