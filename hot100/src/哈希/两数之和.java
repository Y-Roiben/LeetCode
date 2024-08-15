package 哈希;

import java.util.HashMap;

public class 两数之和 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            int num = target - nums[i];
            if (map.containsKey(num)){
                return new int[]{map.get(num), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
