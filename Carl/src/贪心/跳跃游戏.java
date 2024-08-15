package 贪心;

public class 跳跃游戏 {
    public boolean canJump(int[] nums) {

        int maxIndex = 0;
        for (int i = 0; i <= maxIndex; i++) {
            int step = nums[i];
            maxIndex = Math.max(step + i, maxIndex);
            if (maxIndex >= nums.length -1){
                return true;
            }
        }
        return false;
    }

}
