package 贪心;

public class 跳跃游戏II {

    // 每跳一部尽可能增大覆盖范围

    public int jump(int[] nums) {
        if (nums.length <= 1){
            return 0;
        }
        int maxIndex = 0;
        int numSteps = 0;
        int cover = 0;
        for (int i = 0; i <= maxIndex; i++) { // 寻找覆盖范围内的下一段覆盖范围
            int step = nums[i];
             cover = Math.max(step + i, cover);
             if (cover >= nums.length -1){ // 已经可以覆盖了,再走一步就到了
                 return numSteps+1;
             }
             if (i == maxIndex){  // 走到当前范围内的最后一个位置了, 走一步，更新覆盖范围
                 maxIndex = cover;
                 numSteps++;
             }
        }
        return numSteps;
    }
}
