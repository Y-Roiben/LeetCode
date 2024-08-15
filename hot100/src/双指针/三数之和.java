package 双指针;

import java.util.*;

public class 三数之和 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i-1]) continue;
            if (nums[i] > 0) break;

            int left = i+1;
            int right = nums.length-1;
            while (right > left){
                int sum = nums[i] + nums[right] + nums[left];
                if (sum == 0){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[right]);
                    temp.add(nums[left]);
                    res.add(temp);
                    // 左指针向里移动并去重
                    while (left < right){
                        left++;
                        if (nums[left] != nums[left-1]){
                            break;
                        }
                    }
                }else if (sum > 0){
                    right--;
                }else {
                    left++;
                }
            }

        }
        return res;
    }
}
