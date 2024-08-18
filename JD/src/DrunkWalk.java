import java.util.Map;

public class DrunkWalk {
    public static int[] finalPosition(String commands) {
        // Initial position and direction
        int x = 0, y = 0;
        char direction = 'N'; // N: North, E: East, S: South, W: West

        // Direction change map
        Map<Character, Character> leftTurn = Map.of('N', 'W', 'W', 'S', 'S', 'E', 'E', 'N');
        Map<Character, Character> rightTurn = Map.of('N', 'E', 'E', 'S', 'S', 'W', 'W', 'N');

        // Process each command
        for (char command : commands.toCharArray()) {
            switch (command) {
                case 'W':
                    if (direction == 'N') y++;
                    else if (direction == 'E') x++;
                    else if (direction == 'S') y--;
                    else if (direction == 'W') x--;
                    break;
                case 'A':
                    direction = leftTurn.get(direction);
                    break;
                case 'D':
                    direction = rightTurn.get(direction);
                    break;
                case 'S':
                    // Stay in place
                    break;
            }
        }

        return new int[]{x, y};
    }

    public static void main(String[] args) {
        String commands = "WAW";
        int[] finalPos = finalPosition(commands);
        System.out.println("Final Position: (" + finalPos[0] + ", " + finalPos[1] + ")");
    }
}