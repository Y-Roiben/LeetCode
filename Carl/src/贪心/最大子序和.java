package 贪心;

import java.util.List;

public class 最大子序和 {
    public int maxSubArray(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            pre = Math.max(pre + x, x); // 对于x而言，加上pre对于自身有没有变大
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;

    }
    public int maxSubArray2(int[] nums) {
        int sum = nums[0];
        int max = sum;

        for (int i = 1; i < nums.length; i++) {
            if ((sum <= 0 && nums[i] > 0) || (nums[i] <= 0 && sum < nums[i])){

                sum = nums[i];
            }else {
                sum += nums[i];
            }
            max = Math.max(max, sum);
        }

        return max;
    }
    // 暴力
    public int maxSubArray1(int[] nums) {
        int res = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum = sum + nums[j];
                res = Math.max(res, sum);
            }
        }
        return res;
    }
}
