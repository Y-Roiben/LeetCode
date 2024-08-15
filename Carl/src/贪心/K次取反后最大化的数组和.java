package 贪心;

import java.util.*;

public class K次取反后最大化的数组和 {

    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        int index;
        for (index = 0; index < k;) {
            if (index >= nums.length || nums[index] > 0 ){
                break;
            }
            nums[index] = -nums[index];
            index++;
        }
        if ((k - index) % 2 != 0){
            Arrays.sort(nums);
            nums[0] = -nums[0];
        }

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }


    public int largestSumAfterKNegations2(int[] nums, int k) {
        Arrays.sort(nums);
        int sum = 0;
        int min = Integer.MAX_VALUE;
        ArrayList<Integer> list = new ArrayList<>();
        for (int num : nums) {
            sum+=num;
            min = Math.min(min, Math.abs(num));
            if (list.size() < k && num < 0){
                list.add(num);
            }
        }
        for (Integer i : list) {
            sum -= 2*i;
        }
        if (list.size() != k){
            int temp = k - list.size();
            if (temp %2 != 0){
                sum -= 2 * min;
            }
        }
        return sum;
    }

}
