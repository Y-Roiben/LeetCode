package 贪心;

import java.util.Arrays;

public class 用最少数量的箭引爆气球 {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (o1, o2) -> {
            // 先排二维， 再排一维
            if (o1[1] != o2[1]) {
                return Integer.compare(o1[1], o2[1]);
            } else {
                return Integer.compare(o1[0], o2[0]);
            }
        });
        System.out.println(Arrays.deepToString(points));
        int num = 0;
        int end = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > end) {
                end = points[i][1];
                num++;
            }
            end = Math.min(end, points[i][1]);
        }
        return num + 1;  // 最后一组也需要弓箭
    }

    public static void main(String[] args) {
        new 用最少数量的箭引爆气球().findMinArrowShots(new int[][]{{9,12},{1,10},{4,11},{8,12},{3,9},{6,9},{6,7}});
    }



}
