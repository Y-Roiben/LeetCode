import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println(finalSum(arr, k));
    }

    public static int finalSum(int[] arr, int k) {
        int n = arr.length;
        int initialSum = 0;
        for (int num : arr) {
            initialSum += num;
        }

        // Xiaomei's turn: maximize the sum
        int maxIncrease = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int currentSum = 0;
            for (int j = i; j < n; j++) {
                currentSum += arr[j];
                int newSum = initialSum - currentSum + currentSum * k;
                maxIncrease = Math.max(maxIncrease, newSum - initialSum);
            }
        }
        initialSum += maxIncrease;

        // Xiaotuan's turn: minimize the sum
        int maxDecrease = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int currentSum = 0;
            for (int j = i; j < n; j++) {
                currentSum += arr[j];
                int newSum = initialSum - currentSum + currentSum * k;
                maxDecrease = Math.min(maxDecrease, newSum - initialSum);
            }
        }
        initialSum += maxDecrease;

        return initialSum;
    }
}