package 动态规划;

public class 使用最小花费爬楼梯 {
    public int minCostClimbingStairs(int[] cost) {
        // dp 跳到该台阶的最小花费
        int[] dp = new int[cost.length+1];
        // 可以不用初始化， 默认为0
        dp[0] = 0;
        if (cost.length >= 1) dp[1] = 0;
        for (int i = 2; i < cost.length+1; i++) {
            // 跳到i台阶， 从i-2调两步， 或者i-1 跳一步
            dp[i] = Math.min(dp[i-2]+cost[i-2], dp[i -1]+cost[i-1]);
        }
        return dp[cost.length];
    }
}
