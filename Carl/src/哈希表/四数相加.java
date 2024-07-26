package 哈希表;

import java.util.HashMap;
import java.util.Map;

public class 四数相加 {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> map1 = new HashMap<>();
        for (int i : nums1) {
            for (int j : nums2) {
//                if (map1.containsKey(i+j)){
//                    map1.put(i+j, map1.get(i+j) + 1);
//                }else {
//                    map1.put(i+j, 1);
//                }
                map1.put(i+j, map1.getOrDefault(i+j, 0)+1);
            }
        }
        int count = 0;
        for (int i : nums3) {
            for (int j : nums4) {
                int target = -i - j;
                count = count + map1.getOrDefault(target, 0);
            }
        }
        return count;
    }
}
