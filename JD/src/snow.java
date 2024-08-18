import java.util.Scanner;

public class snow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the heights after the snow
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        // Calculate the height of the first pole before the snow
        int heightDiff = b - a;

        long sum = 0;
        for (int i = 1; i <= heightDiff; i++) {
            sum+=i;
        }
        System.out.println(sum - b);


    }
}
