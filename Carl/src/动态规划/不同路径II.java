package 动态规划;

public class 不同路径II {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        // 初始化
        if (obstacleGrid[0][0] == 0) return 0;  // 起点有障碍， 直接返回0
        dp[0][0] = 1;
        for (int i = 1; i < m; i++) {
            if (obstacleGrid[i][0] == 1){
                dp[i][0] = 0;
                continue;
            }
            dp[i][0] = dp[i-1][0];
        }
        for (int i = 1; i < n; i++) {
            if (obstacleGrid[0][i] == 1){
                dp[0][i] = 0;
                continue;
            }
            dp[0][i] = dp[0][i-1];
        }
//        for (int i = 1; i < n; i++) {
//            if (obstacleGrid[0][i] == 1){
//                break;
//            }
//            dp[0][i] = dp[0][i-1];
//        }


        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1){
                    dp[i][j] = 0;
                    continue;
                }
                dp[i][j] = dp[i-1][j] + dp[i][j -1];  // 递推公式
            }
        }
        return dp[m-1][n-1];



    }
}
