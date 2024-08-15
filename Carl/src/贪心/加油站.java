package 贪心;

public class 加油站 {



    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0;
        int start = 0;
        int curSum = 0;
        for (int i = 0; i < gas.length; i++) {
            curSum += gas[i] - cost[i];
            total += gas[i] - cost[i];
            if (curSum < 0){
                // 不需要取余, 从0开始，如果起始点在start前面，不会运行到这里，因此i+1肯定在len里面
                start = i + 1;
                curSum = 0;
            }
        }
        // 不必从start再绕一圈过来, total<0,无论curr大小，都不满足，
        // 题目只有唯一解， start有解，就不必考虑start+1了
        if (total < 0) return -1;
        return start;
    }

}

