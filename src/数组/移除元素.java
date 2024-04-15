package 数组;

import java.util.Map;

public class 移除元素 {
    public static int removeElement(int[] nums, int val) {
//        头指针 尾指针
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            if (nums[left] == val) {
                nums[left] = nums[right];
                nums[right] = val;
                right--;
                continue;
            }
            left++;
        }
        return left;
    }

    public static int removeElement1(int[] nums, int val) {
//      快指针慢指针

        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow;
    }

}
