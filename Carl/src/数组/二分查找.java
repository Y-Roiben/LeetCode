package 数组;

public class 二分查找 {
    public static int searchInsert(int[] nums, int target) {
//        左闭右闭
        int left = 0;
        int right = nums.length - 1;
        int mid;
        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static int searchInsert1(int[] nums, int target) {
//        左闭右开
        int left = 0;
        int right = nums.length;
        int mid;
        while (left < right) {
            mid = (left + right) / 2;
            if (nums[mid] > target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 3, 5, 9, 12};
        System.out.println(searchInsert1(nums, 9));

    }
}
