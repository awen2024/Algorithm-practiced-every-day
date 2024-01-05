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

    // 67. 不同路径
    @Test
    public void testUniquePaths() {
        BM67NumberDifferentPaths bm67NumberDifferentPaths = new BM67NumberDifferentPaths();

        // Test case 1
        int m1 = 1;
        int n1 = 1;
        int expected1 = 1;
        int result1 = bm67NumberDifferentPaths.uniquePaths(m1, n1);
        assertEquals(expected1, result1);

        // Test case 2
        int m2 = 2;
        int n2 = 2;
        int expected2 = 2;
        int result2 = bm67NumberDifferentPaths.uniquePaths(m2, n2);
        assertEquals(expected2, result2);

        // Test case 3
        int m3 = 3;
        int n3 = 3;
        int expected3 = 6;
        int result3 = bm67NumberDifferentPaths.uniquePaths(m3, n3);
        assertEquals(expected3, result3);
    }

    // 68. 最小路径和
    @Test
    public void testMinPathSum() {
        // Test case 1
        int[][] matrix1 = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        int expected1 = 7;
        BM68MinPathSumMatrix solution1 = new BM68MinPathSumMatrix();
        int result1 = solution1.minPathSum(matrix1);
        assertEquals(expected1, result1);

        // Test case 2
        int[][] matrix2 = {{3}};
        int expected2 = 3;
        BM68MinPathSumMatrix solution2 = new BM68MinPathSumMatrix();
        int result2 = solution2.minPathSum(matrix2);
        assertEquals(expected2, result2);

        // Test case 3
        int[][] matrix3 = {{2, 2}, {3, 3}, {4, 4}, {5, 5}, {6, 6}, {7, 7}, {8, 8}, {9, 9}, {10, 10}};
        int expected3 = 56;
        BM68MinPathSumMatrix solution3 = new BM68MinPathSumMatrix();
        int result3 = solution3.minPathSum(matrix3);
        assertEquals(expected3, result3);
    }

    @Test
    public void testNum2Letters() {
        BM69Num2Letters converter = new BM69Num2Letters();
        // Test case 1
        String nums1 = "12298";
        int expected1 = 3;
        int result1 = converter.num2Letters(nums1);
        assertEquals(expected1, result1);

        // Test case 2
        String nums2 = "31717126241541717";
        int expected2 = 192;
        int result2 = converter.num2Letters(nums2);
        assertEquals(expected2, result2);

        // Test case 3
        String nums4 = "13579";
        int expected4 = 2;
        int result4 = converter.num2Letters(nums4);
        assertEquals(expected4, result4);
    }

    // 70. 零钱兑换
    @Test
    public void testExchangeChange() {
        BM70ExchangeChange exchangeChange = new BM70ExchangeChange();

        // Test case 1
        int[] coins1 = {1, 2, 5};
        int amount1 = 11;
        int expected1 = 3;
        int result1 = exchangeChange.exchangeChange(coins1, amount1);
        assertEquals(expected1, result1);

        // Test case 2
        int[] coins2 = {2, 3, 4, 5};
        int amount2 = 15;
        int expected2 = 3;
        int result2 = exchangeChange.exchangeChange(coins2, amount2);
        assertEquals(expected2, result2);

        // Test case 3
        int[] coins3 = {1};
        int amount3 = 0;
        int expected3 = 0;
        int result3 = exchangeChange.exchangeChange(coins3, amount3);
        assertEquals(expected3, result3);

        // Test case 4
        int[] coins4 = {3,  5};
        int amount4 = 2;
        int expected4 = -1;
        int result4 = exchangeChange.exchangeChange(coins4, amount4);
        assertEquals(expected4, result4);
    }
    // 71. 最大升序子序列
    @Test
    public void testMaxAscSubseq() {
        BM71MaxAscSubsequence maxAscSubseq = new BM71MaxAscSubsequence();

        // Test case 1
        int[] arr1 = {1, 2, 3, 4, 5};
        assertEquals(5, maxAscSubseq.maxAscSubseq(arr1));

        // Test case 2
        int[] arr2 = {5, 4, 3, 2, 1};
        assertEquals(1, maxAscSubseq.maxAscSubseq(arr2));

        // Test case 3
        int[] arr3 = {1, 3, 2, 4, 5};
        assertEquals(4, maxAscSubseq.maxAscSubseq(arr3));

        // Test case 4
        int[] arr4 = {};
        assertEquals(0, maxAscSubseq.maxAscSubseq(arr4));
    }
}
