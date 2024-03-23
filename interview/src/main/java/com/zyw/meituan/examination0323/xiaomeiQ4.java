package com.zyw.meituan.examination0323;

import java.util.Scanner;

public class xiaomeiQ4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        long k = in.nextLong();
        in.nextLine();
        String pattern = in.nextLine();
        System.out.println(maxSub(pattern, k));
    }

    private static long maxSub(String pattern, long k) {
        long count = 0;
        long currLen = 0;
        int unique = 0;
        long[] charCounts = new long[26];
        for (int i = 0; i < pattern.length();) {
            char ch = pattern.charAt(i);
            long num = 1;  //重复次数
            if (i+1 < pattern.length() && pattern.charAt(i+1) == '(') {
                i++;
                num = 0;
                while (i+1 < pattern.length() && pattern.charAt(i+1) != ')') {
                    i++;
                    num = num * 10 + (pattern.charAt(i) - '0');
                }
                i++; //右括号
            }

            if (charCounts[ch - 'a'] == 0) {
                unique++;
            }
            charCounts[ch - 'a'] += num;
            currLen += num;
            if (currLen * unique >= k) {
                count++;
                currLen = 0;
                unique = 0;
                charCounts = new long[26];
            }
            i++;
        }
        if (count == 0 && currLen > 0) {
            return -1;
        }
        return count;
    }
}
