package 数组;

public class 长度最小的子数组 {
    public int minSubArrayLen(int target, int[] nums) {
        int resLen = Integer.MAX_VALUE;
        int left = 0;
        int sum = 0;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum >= target){
                resLen = Math.min(resLen, right - left +1);
                sum = sum - nums[left];
                left++;
            }
        }
        return resLen == Integer.MAX_VALUE? 0: resLen;
    }
}
