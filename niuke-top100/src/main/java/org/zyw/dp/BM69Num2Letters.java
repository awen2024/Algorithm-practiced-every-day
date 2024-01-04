package org.zyw.dp;

public class BM69Num2Letters {
    public int num2Letters(String nums) {
        int len = nums.length();
        int[] dp = new int[len + 1];
        dp[0] = 1;
        dp[1] = nums.charAt(0) != '0' ? 1 : 0;
        for (int i = 2; i <= len; i++) {
            int first = Integer.parseInt(nums.substring(i - 1, i));
            int second = Integer.parseInt(nums.substring(i - 2, i));

            if (first >= 1 && first <= 9) {
                dp[i] += dp[i - 1];
            }
            if (second >= 10 && second <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[len];
    }
}
