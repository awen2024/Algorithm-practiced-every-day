package org.zyw.dp;

public class BM63JumpFloor {
    /**
     * 给定一个整数数组 floors，表示每个房间的地板高度。
     * 从房间的地板开始，你每次可以选择跳一个或两个房间的长度。
     * 如果在某个房间可以到达某个地板，则该地板的值为1，否则为0。
     * 返回从第一个房间跳到目标房间所需的最小跳数。
     * 如果无法到达目标房间，则返回 -1。
     *
     * @param target 目标房间的地板编号
     * @return 最小跳数
     */
    public static int jumpFloor(int target) {
        int[] dp = new int[target + 1]; // 创建一个长度为 target+1 的数组 dp，存储到达每个房间的最小跳数
        dp[0] = 1; // 房间0的最小跳数为1
        dp[1] = 1; // 房间1的最小跳数为1
        for (int i = 2; i <= target; i++) {
            dp[i] = dp[i - 1] + dp[i - 2]; // 动态规划计算到达每个房间的最小跳数
        }
        return dp[target]; // 返回到达目标房间的最小跳数
    }

}
