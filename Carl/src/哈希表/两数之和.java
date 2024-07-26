package 哈希表;

import java.util.HashMap;
import java.util.Map;

public class 两数之和 {
    public int[] twoSum(int[] nums, int target) {
        // zhiyou
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int j = target - nums[i];
            boolean b = map.containsKey(j);
            Integer i1 = map.get(j);
            if (b && i1 != i){
                return new int[]{i, i1};
            }
        }

        return null;
    }

    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            // 只有一个结果， 可以边存边查
            int j = target - nums[i];
            boolean b = map.containsKey(j);
            if (b){
                return new int[]{i, map.get(j)};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
