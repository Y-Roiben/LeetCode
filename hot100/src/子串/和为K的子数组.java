package 子串;

import java.util.Arrays;

public class 和为K的子数组 {
    public int subarraySum(int[] nums, int k) {


        return 0;
    }

    public int subarraySum1(int[] nums, int k) {
        // 暴力
        int count = 0;
        for (int start = 0; start < nums.length; start++) {
            int sum = 0;
            for (int end = start; end < nums.length; end++) {
                sum = sum + nums[end];
                if (sum == k){
                    count++;
                }
            }
        }
        return count;
    }

}
