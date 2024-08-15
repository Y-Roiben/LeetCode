package 哈希;

import java.util.Arrays;

public class 最长连续序列 {
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                res++;
                continue;
            }
            if (nums[i] == nums[i - 1]) continue;
            if (nums[i] - nums[i - 1] == 1){
                res++;
            }else {
                max = Math.max(res, max);
                res = 1;
            }
        }
        return max;

    }


}
