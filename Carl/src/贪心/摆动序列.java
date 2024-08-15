package 贪心;

public class 摆动序列 {

    public int wiggleMaxLength(int[] nums) {
        if (nums.length <= 1){
            return nums.length;
        }

        // 处理开头
        int start;
        int preDiff = 0;
        for (start = 1; start < nums.length; start++) {
            // 找到第一个有坡度的位置
            preDiff = nums[start] - nums[start - 1];
            if (preDiff != 0){
                break;
            }
        }
        // 结束了还是平坡
        if (preDiff ==0){
            return 1;
        }

        int currDiff;
        int res = 2; // 有了坡度了，最少都有两个了
        for (int i = start; i < nums.length-1; i++) {
            currDiff = nums[i+1] - nums[i];
            if (currDiff == 0){
                // 平坡
                continue;
            }
            if (currDiff * preDiff < 0){
                res++;
                preDiff = currDiff;
            }
        }
        return res;
    }


    public int wiggleMaxLength1(int[] nums) {

        if (nums.length == 1){
            return 1;
        }

        int res = 1;
        int currDiff = 0;
        int preDiff = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            currDiff = nums[i + 1]  - nums[i];
            if ((preDiff>=0 && currDiff <0) || (preDiff <= 0 && currDiff >0)){
                res++;
                preDiff = currDiff;
            }
        }
        return res;
    }

}
