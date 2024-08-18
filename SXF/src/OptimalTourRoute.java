import java.util.*;




/**肖林在大学毕业后，计划安排一次愉快的旅游，所以提前对想去的旅游景点进行了量化评估，方便挑选出最优的旅游路线。
 * 评估维度分为三个属性，分别为m、n和（x,y），其中m：代表疲劳值；n：代表兴奋值；（x,y)：代表景点位置。
 * 家所在位置为（0，0）并且从旅游景点（x1,y1）到旅游景点（x2,y2），
 * 会产生一定的疲劳值，其疲劳值为|x1-x2|+|y1-y2|。选择k个旅游景点，计算最终的疲劳值cm和兴奋值cn，
 * 而cn/cm则代表本次旅游的舒适值，舒适值最高的旅游路线，即表示为最优的旅游路线。
 * cm:代表所有旅游景点的疲劳值之和，再加上路上所产生的疲劳值。cn：代表所有旅游景点的兴奋值之和。
 现在有t个旅游景点，肖林准备选择k个景区进行游玩，旅游路线需从家里出发，经过k个景区并最终回到家里。请为肖林规划好最优的旅游路线*/
public class OptimalTourRoute {
    static class Spot {
        int fatigue;
        int excitement;
        int x;
        int y;

        Spot(int fatigue, int excitement, int x, int y) {
            this.fatigue = fatigue;
            this.excitement = excitement;
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        String[] split = string.split(" ");
        int t = Integer.parseInt(split[0]);
        int k = Integer.parseInt(split[1]);
        List<Spot> spots = new ArrayList<>();

        for (int i = 0; i < t; i++) {
            split = scanner.nextLine().split(" ", 3);
            int m = Integer.parseInt(split[0]);
            int n = Integer.parseInt(split[1]);
            String[] split1 = split[2].split(" ");
            int x = Integer.parseInt(split1[0].substring(1));
            int y = Integer.parseInt(split1[1].substring(0, split1[1].length() - 1));
            spots.add(new Spot(m, n, x, y));
        }

        List<List<Spot>> combinations = new ArrayList<>();
        generateCombinations(spots, k, 0, new ArrayList<>(), combinations);

        double maxComfortValue = -1;

        for (List<Spot> route : combinations) {
            int cm = calculateTotalFatigue(route);
            int cn = calculateTotalExcitement(route);
            double comfortValue = (double) cn / cm;

            if (comfortValue > maxComfortValue) {
                maxComfortValue = comfortValue;
            }
        }
        System.out.printf("%6f\n", maxComfortValue);
    }

    private static void generateCombinations(List<Spot> spots, int k, int start, List<Spot> current, List<List<Spot>> combinations) {
        if (current.size() == k) {
            combinations.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < spots.size(); i++) {
            current.add(spots.get(i));
            generateCombinations(spots, k, i + 1, current, combinations);
            current.remove(current.size() - 1);
        }
    }

    private static int calculateTotalFatigue(List<Spot> route) {
        int totalFatigue = 0;
        int prevX = 0, prevY = 0;

        for (Spot spot : route) {
            totalFatigue += spot.fatigue;
            totalFatigue += Math.abs(spot.x - prevX) + Math.abs(spot.y - prevY);
            prevX = spot.x;
            prevY = spot.y;
        }

        totalFatigue += Math.abs(prevX) + Math.abs(prevY); // Return to home
        return totalFatigue;
    }

    private static int calculateTotalExcitement(List<Spot> route) {
        int totalExcitement = 0;
        for (Spot spot : route) {
            totalExcitement += spot.excitement;
        }
        return totalExcitement;
    }
}