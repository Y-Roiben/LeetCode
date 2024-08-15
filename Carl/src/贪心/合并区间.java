package 贪心;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class 合并区间 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });

        List<int[]> res = new ArrayList<>();
        int start = intervals[0][0];
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= end){
                end = Math.max(intervals[i][1], end);
            }else {
                res.add(new int[]{start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        res.add(new int[]{start, end});

//        int[][] array = new int[res.size()][];
//        for (int i = 0; i < res.size(); i++) {
//            array[i] = res.get(i);
//        }
        return res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args) {
        int[][] array = new int[][]{{1,4},{2,3}};
        new 合并区间().merge(array);
    }
}
