import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GCD {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            boolean found = false;

            for (int m = 2; m <= n; m++) {
                int gcdValue = gcd(n, m);
                if (isPrime(gcdValue)) {
                    res.add(m);
                    found = true;
                    break;
                }
            }

            if (!found) {
                res.add(-1);
            }
        }
        for (Integer re : res) {
            System.out.println(re);
        }
    }

    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    private static boolean isPrime(int num) {
        if (num <= 1) return false;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}