package org.zyw.dp;

public class BM66LongestCommonSubstring {
    public String longestCommonSubstring(String s1, String s2) {

        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m + 1][n + 1];
        int x = 0,  max = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    if (dp[i][j] > max) {
                        max = dp[i][j];
                        x = i;
                    }
                }
            }
        }
        return s1.substring(x - max, x);
    }
}
