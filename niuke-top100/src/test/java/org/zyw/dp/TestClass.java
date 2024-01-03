package org.zyw.dp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestClass {
    // 63. 跳台阶
    @Test
    public void testJumpFloor() {
        // Test case 1
        int target1 = 5;
        int expectedResult1 = 8;
        assertEquals(expectedResult1, BM63JumpFloor.jumpFloor(target1));

        // Test case 2
        int target2 = 7;
        int expectedResult2 = 21;
        assertEquals(expectedResult2, BM63JumpFloor.jumpFloor(target2));
    }
    // 64. 最小花费爬楼梯
    @Test
    public void testMinCostClimbingStairs() {
        // Test case 1
        int[] cost1 = {2,5,20};
        int expected1 = 5;
        int actual1 = BM64MinCostClimbingStairs.minCostClimbingStairs(cost1);
        assertEquals(expected1, actual1);

        // Test case 2
        int[] cost2 = {1,100,1,1,1,90,1,1,80,1};
        int expected2 = 6;
        int actual2 = BM64MinCostClimbingStairs.minCostClimbingStairs(cost2);
        assertEquals(expected2, actual2);

    }

    // 65. 最长公共子序列
    @Test
    public void testLongestCommonSubsequence() {
        // Test case 1
        String s1 = "ABCD";
        String s2 = "ACDF";
        String expected1 = "ACD";
        assertEquals(expected1, BM65LongestCommonSubsequence.longestCommonSubsequence(s1, s2));

        // Test case 2
        String s3 = "ABCD";
        String s4 = "ABCD";
        String expected2 = "ABCD";
        assertEquals(expected2, BM65LongestCommonSubsequence.longestCommonSubsequence(s3, s4));

        // Test case 3
        String s5 = "ABCD";
        String s6 = "EFGH";
        assertEquals("-1", BM65LongestCommonSubsequence.longestCommonSubsequence(s5, s6));
    }
    // 66. 最长公共子串
    @Test
    public void testLongestCommonSubstring() {
        BM66LongestCommonSubstring lcs = new BM66LongestCommonSubstring();

        // Test case 1
        String s11 = "abcde";
        String s21 = "cdef";
        assertEquals("cde", lcs.longestCommonSubstring(s11, s21));

        // Test case 3
        String s13 = "java";
        String s23 = "java";
        assertEquals("java", lcs.longestCommonSubstring(s13, s23));
    }
}
