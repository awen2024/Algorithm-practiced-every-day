package org.zyw.dp;

public class BM76RegMatch {
    //需要巩固

    public boolean match (String str, String pattern) {
        // write code here
        int m = str.length(), n = pattern.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 2; i <= n; i++) {
            if (pattern.charAt(i - 1) == '*') {
                dp[0][i] = dp[0][i - 2];
            }
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (pattern.charAt(j - 1) == '.' || str.charAt(i - 1) == pattern.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pattern.charAt(j - 1) == '*') {
                    if (pattern.charAt(j - 2) != '.' && str.charAt(i - 1) != pattern.charAt(j - 2)) {
                        dp[i][j] = dp[i][j - 2];
                    } else {
                        dp[i][j] = dp[i - 1][j] || dp[i][j - 2] || dp[i][j - 1];
                    }
                }

            }
        }
        return dp[m][n];
    }

}
