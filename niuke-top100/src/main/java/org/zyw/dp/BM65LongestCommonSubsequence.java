package org.zyw.dp;

public class BM65LongestCommonSubsequence {
    public static String longestCommonSubsequence(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j]= Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        if (dp[m][n]==0) return "-1";
        StringBuffer sb = new StringBuffer();
        while (m > 0 && n > 0) {
            if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
                sb.append(s1.charAt(m - 1));
                m--;
                n--;
            } else if (dp[m - 1][n] > dp[m][n - 1]) {
                m--;
            } else {
                n--;
            }
        }
        return sb.reverse().toString();
    }
}
