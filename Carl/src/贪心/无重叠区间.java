package 贪心;

import java.util.Arrays;
import java.util.Comparator;

public class 无重叠区间 {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        System.out.println(Arrays.deepToString(intervals));
        int res = 0;
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0]<end){
                res++;
                continue;
            }
            end = intervals[i][1];
        }
        return res;
    }

    public static void main(String[] args) {
        new 无重叠区间().eraseOverlapIntervals(new int[][]{{1,2},{2,3},{3,4},{1,3}});
    }
}
