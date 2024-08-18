import java.util.*;

public class FrogJump {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] parts = input.split(",", 4);
        int L = Integer.parseInt(parts[0]);
        int S = Integer.parseInt(parts[1]);
        int T = Integer.parseInt(parts[2]);
        String[] stoneParts = parts[3].substring(1, parts[3].length() - 1).split(",");
        Set<Integer> stones = new HashSet<>();
        for (String stone : stoneParts) {
            stones.add(Integer.parseInt(stone));
        }
        System.out.println(minStones(L, S, T, stones));
    }

    public static int minStones(int L, int S, int T, Set<Integer> stones) {
        Queue<int[]> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.add(new int[]{0, 0}); // {position, stones stepped on}
        visited.add(0);

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int position = current[0];
            int stonesStepped = current[1];

            for (int jump = S; jump <= T; jump++) {
                int newPosition = position + jump;
                if (newPosition >= L) {
                    return stonesStepped;
                }
                if (!visited.contains(newPosition)) {
                    visited.add(newPosition);
                    queue.add(new int[]{newPosition, stonesStepped + (stones.contains(newPosition) ? 1 : 0)});
                }
            }
        }
        return -1; // If the frog cannot reach the end
    }
}