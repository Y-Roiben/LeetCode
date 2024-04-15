package 数组;

import java.util.Arrays;

public class 有序数组的平方 {
    public static int[] sortedSquares(int[] nums) {
//        暴力
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }

    public static int[] sortedSquares1(int[] nums) {
        int[] Res = new int[nums.length];
        int index = nums.length - 1;
        int left;
        int right;
        for (left = 0, right = nums.length - 1; left <= right; ) {
            if (nums[left] * nums[left] > nums[right] * nums[right]) {
                Res[index] = nums[left] * nums[left];
                left++;
            } else {
                Res[index] = nums[right] * nums[right];
                right--;
            }
            index--;
        }

        return Res;
    }


    public static void main(String[] args) {
        int[] nums = {-4, -1, 0, 3, 10};
        System.out.println(Arrays.toString(sortedSquares(nums)));
    }

}
