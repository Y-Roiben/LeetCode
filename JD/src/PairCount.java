import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PairCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read N and X
        int N = scanner.nextInt();
        int X = scanner.nextInt();
        
        // Read the sequence a
        int[] a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = scanner.nextInt();
        }
        
        // HashMap to store the frequency of each element
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        int pairCount = 0;
        
        // Iterate through the sequence
        for (int i = 0; i < N; i++) {
            int complement = X - a[i];
            if (frequencyMap.containsKey(complement)) {
                pairCount += frequencyMap.get(complement);
            }
            frequencyMap.put(a[i], frequencyMap.getOrDefault(a[i], 0) + 1);
        }
        
        // Output the result
        System.out.println(pairCount);
    }
}