import java.util.Scanner;

/**
 * 在一个神秘的森林中，住着一群聪明的小动物。
 * 每只小动物都有一个独特的魔法数字。一天，
 * 森林中的智者决定进行一次特殊的仪式，需要小动物们按顺序站好，
 * 从中挑出不少于一只小动物站成一队，现在需要从这个队伍中挑选出来
 * 一些小动物，实现挑出的小动物的魔法数字之和是最大的，要求挑选出
 * 来的小动物不能改变其在原始队伍中的相对位置，并且挑选出来的小动
 * 物在原队伍中的位置间隔不能小于K.*/

public class MaxMagicSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read n and K
        String[] split = scanner.nextLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int K = Integer.parseInt(split[1]);

        // Read the magic numbers
        int[] magicNumbers = new int[n];
        split = scanner.nextLine().split(" ");
        for (int i = 0; i < n; i++) {
            magicNumbers[i] = Integer.parseInt(split[i]);
        }

        // DP array to store the maximum sum up to each position
        int[] dp = new int[n];

        // Initialize the DP array with the magic numbers
        for (int i = 0; i < n; i++) {
            dp[i] = magicNumbers[i];
        }

        // Fill the DP array
        for (int i = 0; i < n; i++) {
            for (int j = i + K; j < n; j++) {
                dp[j] = Math.max(dp[j], dp[i] + magicNumbers[j]);
            }
        }

        // Find the maximum value in the DP array
        int maxSum = 0;
        for (int i = 0; i < n; i++) {
            maxSum = Math.max(maxSum, dp[i]);
        }

        // Output the result
        System.out.println(maxSum);

        scanner.close();
    }
}