package 双指针;

public class 移动零 {
    public void moveZeroes(int[] nums) {
        // 保持非零的相对距离
        if(nums==null){
            return;
        }
        int fast = 0;
        int slow = 0;
        while (fast < nums.length){
            if (nums[fast] == 0){
                fast++;
                continue;
            }
            int swap = nums[slow];
            nums[slow] = nums[fast];
            nums[fast] = swap;
            slow++;
            fast++;
        }
    }

    public void moveZeroes1(int[] nums) {
        if(nums==null){
            return;
        }
        // 保持非零的相对距离
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] !=0){
                nums[slow] = nums[fast];
                slow++;
            }
        }
        for (int i = slow; i < nums.length; i++) {
            nums[i] = 0;
        }
    }


}
