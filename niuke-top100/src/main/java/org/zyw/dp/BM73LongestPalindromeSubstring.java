package org.zyw.dp;

import java.util.Arrays;

public class BM73LongestPalindromeSubstring {
    public int getLongestPalindrome (String A) {
        // write code here
        int n = A.length();
        char[] arr = new char[2 * n - 1];
        Arrays.fill(arr, '#');
        for (int i = 0; i < n; i++) {
            arr[2 * i] = A.charAt(i);
        }
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            int ans = spread(arr, i);
            res = Math.max(ans, res);
        }
        return res;
    }

    private int spread(char[] arr, int center) {
        int l = center - 1, r = center + 1, ans = arr[center] == '#' ? 0 : 1;
        while (l >= 0 && r < arr.length && arr[l] == arr[r]) {
            if (arr[l] != '#') {
                ans += 2;
            }
            l--;
            r++;
        }
        return ans;
    }
}
