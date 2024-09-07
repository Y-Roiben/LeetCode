package 动态规划;

import java.util.Arrays;

public class 不同的二叉搜索树 {
    public int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        if (n >=1) dp[1] = 1;
        for (int i = 2; i < n+1; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - 1 -j];
            }
        }
        System.out.println(Arrays.toString(dp));

        return 0;
    }

    public static void main(String[] args) {
        new 不同的二叉搜索树().numTrees(3);
    }
}
