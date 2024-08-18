import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class code1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        // Read n, m, and α
        String[] split = scanner.nextLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);
        int a = Integer.parseInt(split[2]);

        // Read the roads
        List<int[]>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            split = scanner.nextLine().split(" ");
            int u = Integer.parseInt(split[0]);
            int v = Integer.parseInt(split[1]);
            int w = Integer.parseInt(split[2]);

            graph[u].add(new int[]{v, w});
        }

        // DP array
        int[][] dp = new int[n + 1][a + 1];
        dp[1][0] = 1; // Start at city 1 with 0 cost

        // Fill the DP array
        for (int cost = 0; cost <= a; cost++) {
            for (int city = 1; city <= n; city++) {
                if (dp[city][cost] > 0) {
                    for (int[] road : graph[city]) {
                        int nextCity = road[0];
                        int nextCost = cost + road[1];
                        if (nextCost <= a) {
                            dp[nextCity][nextCost] += dp[city][cost];
                        }
                    }
                }
            }
        }

        // Output the result
        int res = dp[n][a];
        if (res >= 20220201) {
            System.out.println("All roads lead to Home!");
            System.out.println(res % 20220201);
        } else {
            System.out.println(res);
        }
        scanner.close();
    }
}