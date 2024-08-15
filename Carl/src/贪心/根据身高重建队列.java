package 贪心;

import java.util.*;
import java.util.function.IntFunction;

public class 根据身高重建队列 {
    public int[][] reconstructQueue(int[][] people) {

        Arrays.sort(people, (o1, o2) -> {
            if (o2[0] == o1[0]){
                return o1[1] - o2[1];
            }
            return o2[0] - o1[0];
        });

        ArrayList<int[]> res = new ArrayList<>();
        for (int[] p : people) {
            res.add(p[1], p);
        }

//        for (int i = 0; i < list.size(); i++) {
//            int[] p = list.get(i);
//            int num = p[1];
//            if (num == i){
//                res.add(p);
//            }else {
//                res.add(num, p);
//            }
//        }
        return res.toArray(new int[people.length][]);
    }

}
