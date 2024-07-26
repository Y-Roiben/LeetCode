package 哈希表;

import java.util.*;
import java.util.stream.IntStream;

public class 三数之和 {
//    双指针
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        


        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0){
                return res;
            }
            if (i > 0 && nums[i] == nums[i-1] ){
                continue;
            }

            List<Integer> temp = new ArrayList<>();
            int left = i +1;
            int right = nums.length - 1;
            while (left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if (sum > 0){
                    right--;
                }else if (sum<0){
                    left++;
                }else {
                    temp.add(nums[i]);
                    temp.add(nums[left]);
                    temp.add(nums[right]);
                }
                
            }
        }

        return res;
    }

}
