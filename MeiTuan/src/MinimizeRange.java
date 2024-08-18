import java.util.Arrays;
import java.util.Scanner;

public class MinimizeRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String s = scanner.nextLine();
        String[] split = s.split(" ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(split[i]);
        }
        System.out.println(minimizeRange(arr));
    }

    public static int minimizeRange(int[] arr) {
        Arrays.sort(arr);
        int operations = 0;
        int left = 0;
        int right = arr.length - 1;

        while (arr[right] - arr[left] > 1) {
            arr[right]--;
            arr[left]++;
            operations++;
//            Arrays.sort(arr);
            // Adjust the right pointer
            if (arr[left] > arr[left + 1]) {
                left++;
            }
            if (arr[right] <= arr[right - 1]) {
                right--;
            }
        }
        if (operations == 0){
            return 0;
        }else {
            return operations+minimizeRange(arr);
        }
    }
}