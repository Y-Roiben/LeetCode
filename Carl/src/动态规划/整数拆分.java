package 动态规划;

import java.util.Arrays;

public class 整数拆分 {
    public int integerBreak(int n) {
        int[] dp = new int[n+1];

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                // i * (i-j) 还是i * dp(i-j)
                dp[i] = Math.max(Math.max(j * dp[i - j], j * (i - j)), dp[i]);
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[n];
    }

    public static void main(String[] args) {
        new 整数拆分().integerBreak(10);
    }
}
