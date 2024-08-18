import java.util.Scanner;

public class code {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] split1 = s.split(" ");
        int n = Integer.parseInt(split1[0]);
        int m = Integer.parseInt(split1[1]);
        String in = scanner.nextLine();
        String[] split = in.split("");
        int[] block1 = new int[n];
        for (int i = 0; i < n; i++) {
            block1[i] = Integer.parseInt(split[i]);
        }
        in = scanner.nextLine();
        split = in.split("");
        int[] block2 = new int[m];
        for (int i = 0; i < m; i++) {
            block2[i] = Integer.parseInt(split[i]);
        }

        int minLength = n + m;

        // Iterate through all possible starting positions for the second block
        for (int start = -m + 1; start < n; start++) {
            boolean valid = true;
            for (int i = 0; i < m; i++) {
                int pos = start + i;
                if (pos >= 0 && pos < n && block1[pos] + block2[i] > 3) {
                    valid = false;
                    break;
                }
            }
            if (valid) {
                int combinedLength = Math.max(n, start + m) - Math.min(0, start);
                minLength = Math.min(minLength, combinedLength);
            }
        }
        System.out.println(minLength);
    }
}
